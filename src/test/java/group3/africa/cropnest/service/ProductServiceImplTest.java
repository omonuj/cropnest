package group3.africa.cropnest.service;

import group3.africa.cropnest.CropNestApplication;
import group3.africa.cropnest.dto.CategoryRequest;
import group3.africa.cropnest.dto.ProductRequestDTO;
import group3.africa.cropnest.dto.ProductResponseDTO;
import group3.africa.cropnest.repository.CategoryRepository;
import group3.africa.cropnest.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = CropNestApplication.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }


    @Test
    void test_that_admin_can_add_product_to_category() {
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setCategoryName("Yam Tubers");
        CategoryRequest categoryResponse = categoryService.createCategory(categoryRequest);
        assertNotNull(categoryResponse);
        assertNotNull(categoryResponse.getCategoryId(), "Category ID should not be null.");

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Yam");
        productRequestDTO.setProductDescription("sweet yam, 2kg");
        productRequestDTO.setProductPrice(3500);
        productRequestDTO.setProductQuantity(3);
        productRequestDTO.setProductImageUrl("yam.jpg");
        productRequestDTO.setDiscountedPrice(2800);
        ProductResponseDTO productResponse = productService.addProduct(categoryResponse.getCategoryId(), productRequestDTO);

        // Assertions for added product
        assertNotNull(productResponse);
        assertEquals("Yam", productResponse.getProductName(), "Product name mismatch.");
        assertEquals("sweet yam, 2kg", productResponse.getProductDescription(), "Product description mismatch.");
        assertEquals(3500, productResponse.getProductPrice(), "Product price mismatch.");
        assertEquals(3, productResponse.getProductQuantity(), "Product quantity mismatch.");
        assertEquals(1, productRepository.count(), "Unexpected product repository count.");
    }
}





//    @Test
//    void getProductById() {
//    }
//
//    @Test
//    void updateProductById() {
//    }
//
//    @Test
//    void getAllProducts() {
//    }
//
//    @Test
//    void deleteProductById() {
//    }
//}