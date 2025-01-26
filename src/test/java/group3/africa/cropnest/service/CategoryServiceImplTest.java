package group3.africa.cropnest.service;

import group3.africa.cropnest.dto.CategoryResponse;
import group3.africa.cropnest.exception.APIException;
import group3.africa.cropnest.model.Category;
import group3.africa.cropnest.repository.CategoryRepository;
import group3.africa.cropnest.dto.CategoryRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

        @Mock
        private CategoryRepository categoryRepository;

        @Mock
        private ModelMapper modelMapper;

        @InjectMocks
        private CategoryServiceImpl categoryService;

        private Category category;
        private CategoryRequest categoryRequest;

        @BeforeEach
        void setUp() {
            category = new Category();
            category.setCategoryId(1L);
            category.setCategoryName("Test Category");

            categoryRequest = new CategoryRequest(1L, "Test Category");

            // Common stubbings
            when(modelMapper.map(categoryRequest, Category.class)).thenReturn(category);
            when(modelMapper.map(category, CategoryRequest.class)).thenReturn(categoryRequest);
        }

        @Test
        void createCategory_success() {
            when(categoryRepository.findByCategoryName("Test Category")).thenReturn(null);
            when(categoryRepository.save(any(Category.class))).thenReturn(category);

            CategoryRequest result = categoryService.createCategory(categoryRequest);

            assertNotNull(result);
            assertEquals(1L, result.getCategoryId());
            assertEquals("Test Category", result.getCategoryName());
            verify(categoryRepository, times(1)).findByCategoryName("Test Category");
            verify(categoryRepository, times(1)).save(any(Category.class));
        }

        @Test
        void createCategory_alreadyExists() {
            when(categoryRepository.findByCategoryName("Test Category")).thenReturn(category);

            APIException exception = assertThrows(APIException.class, () -> {
                categoryService.createCategory(categoryRequest);
            });

            assertEquals("Category with the name Test Category already exists !!!", exception.getMessage());
            verify(categoryRepository, times(1)).findByCategoryName("Test Category");
            verify(categoryRepository, never()).save(any(Category.class));
        }

        @Test
        void testGetAllCategories() {
            int pageNumber = 0;
            int pageSize = 10;
            String sortBy = "name";
            String sortOrder = "asc";

            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
            Page<Category> categoryPage = new PageImpl<>(List.of(category), pageable, 1);

            when(categoryRepository.findAll(pageable)).thenReturn(categoryPage);

            CategoryResponse response = categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);

            assertNotNull(response);
            assertEquals(1, response.getTotalElements());
            assertEquals(1, response.getTotalPages());
            assertEquals(1, response.getContent().size());
            assertEquals("Test Category", response.getContent().get(0).getCategoryName());
        }

        @Test
        void testGetAllCategories_noCategories() {
            int pageNumber = 0;
            int pageSize = 10;
            String sortBy = "name";
            String sortOrder = "asc";

            Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
            Page<Category> categoryPage = new PageImpl<>(Collections.emptyList(), pageable, 0);

            when(categoryRepository.findAll(pageable)).thenReturn(categoryPage);

            APIException exception = assertThrows(APIException.class, () -> {
                categoryService.getAllCategories(pageNumber, pageSize, sortBy, sortOrder);
            });

            assertEquals("No category created till now.", exception.getMessage());
        }
    }


//    @Test
//    void deleteCategory() {
//    }
//
//    @Test
//    void updateCategory() {
//    }
