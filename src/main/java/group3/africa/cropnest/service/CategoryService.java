package group3.africa.cropnest.service;

import group3.africa.cropnest.dto.CategoryRequest;
import group3.africa.cropnest.dto.CategoryResponse;
import jakarta.validation.Valid;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryRequest createCategory(@Valid CategoryRequest categoryRequest);


    CategoryRequest deleteCategory(Long categoryId);


    CategoryRequest updateCategory(CategoryRequest categoryRequest, Long categoryId);
}
