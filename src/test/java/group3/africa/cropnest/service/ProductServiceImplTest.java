package group3.africa.cropnest.service;

import group3.africa.cropnest.CropNestApplication;
import group3.africa.cropnest.dto.CategoryRequest;
import group3.africa.cropnest.dto.ProductRequestDTO;
import group3.africa.cropnest.dto.ProductResponseDTO;
import group3.africa.cropnest.repository.CategoryRepository;
import group3.africa.cropnest.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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

        assertNotNull(productResponse);
        assertEquals("Yam", productResponse.getProductName(), "Product name mismatch.");
        assertEquals("sweet yam, 2kg", productResponse.getProductDescription(), "Product description mismatch.");
        assertEquals(3500, productResponse.getProductPrice(), "Product price mismatch.");
        assertEquals(3, productResponse.getProductQuantity(), "Product quantity mismatch.");
        assertEquals(1, productRepository.count(), "Unexpected product repository count.");
    }


    @Test
    void test_that_product_can_be_gotten_by_id() {
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
        assertNotNull(productResponse);
        ProductResponseDTO createdProduct = productService.getProductById(productResponse.getProductId());
        assertNotNull(createdProduct);
        Assertions.assertEquals(productRequestDTO.getProductName(), createdProduct.getProductName());
        Assertions.assertEquals(1, productRepository.count());
    }

    @Test
    void test_that_product_can_be_deleted_by_id() {
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setCategoryName("Test Category");
        CategoryRequest categoryResponse = categoryService.createCategory(categoryRequest);
        assertNotNull(categoryResponse);

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Test Product");
        productRequestDTO.setProductDescription("sweet yam, 2kg");
        productRequestDTO.setProductPrice(3500);
        productRequestDTO.setProductQuantity(3);
        productRequestDTO.setProductImageUrl("yam.jpg");
        productRequestDTO.setDiscountedPrice(2800);
        ProductResponseDTO productResponse = productService.addProduct(categoryResponse.getCategoryId(), productRequestDTO);
        assertNotNull(productResponse);
        assertEquals(1, productRepository.count());
        assertEquals("Test Product", productResponse.getProductName(), "Product name mismatch.");
        ProductResponseDTO createdProduct = productService.deleteProductById(productResponse.getProductId());
        Assertions.assertEquals(0, productRepository.count());
    }


    @Test
    void test_that_product_Updated_by_Id_successfully() {
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setCategoryName("Crop type");
        CategoryRequest categoryResponse = categoryService.createCategory(categoryRequest);
        assertNotNull(categoryResponse);
        assertNotNull(categoryResponse.getCategoryId());

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Cash crops");
        productRequestDTO.setProductDescription("crops for cash, 2kg");
        productRequestDTO.setProductPrice(37200);
        productRequestDTO.setProductQuantity(14);
        productRequestDTO.setProductImageUrl("yam.jpg");
        productRequestDTO.setDiscountedPrice(1100);
        ProductResponseDTO productResponse = productService.addProduct(categoryResponse.getCategoryId(), productRequestDTO);
        assertNotNull(productResponse);
        assertEquals(1, productRepository.count());
        assertEquals("Cash crops", productResponse.getProductName(), "Product name mismatch.");

        ProductRequestDTO updateRequestDTO = new ProductRequestDTO();
        updateRequestDTO.setProductName("Food crops");
        updateRequestDTO.setProductDescription("Rice, 25kg");
        updateRequestDTO.setProductPrice(55000);
        updateRequestDTO.setProductQuantity(2);
        updateRequestDTO.setProductImageUrl("rice.jpg");
        updateRequestDTO.setDiscountedPrice(900.00);
        ProductResponseDTO updatedProductResponse = productService.updateProductById(productResponse.getProductId(), updateRequestDTO);
        assertNotNull(updatedProductResponse);

        assertEquals(1, productRepository.count());
        assertEquals("Food crops", updatedProductResponse.getProductName(), "Product name mismatch.");
        assertEquals("Rice, 25kg", updatedProductResponse.getProductDescription(), "Product description mismatch.");
        assertEquals(55000, updatedProductResponse.getProductPrice(), "Product price mismatch.");
        assertEquals(2, updatedProductResponse.getProductQuantity(), "Product quantity mismatch.");
        assertEquals("rice.jpg", updatedProductResponse.getProductImageUrl(), "Product image URL mismatch.");
    }

    @Test
    void test_get_All_products_success(){
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setCategoryName("Crop type");
        CategoryRequest categoryResponse = categoryService.createCategory(categoryRequest);
        assertNotNull(categoryResponse);
        assertNotNull(categoryResponse.getCategoryId());
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Cash crops");
        productRequestDTO.setProductDescription("Rice, 25kg");
        productRequestDTO.setProductPrice(55000);
        productRequestDTO.setProductQuantity(2);
        productRequestDTO.setProductImageUrl("rice.jpg");
        productRequestDTO.setDiscountedPrice(900.00);
        ProductResponseDTO responseDTO = productService.addProduct(categoryResponse.getCategoryId(), productRequestDTO);
        assertNotNull(responseDTO);
        assertEquals(1, productRepository.count());

        CategoryRequest categoryRequest2 = new CategoryRequest();
        categoryRequest2.setCategoryName("Test category");
        CategoryRequest categoryResponse2 = categoryService.createCategory(categoryRequest2);
        assertNotNull(categoryResponse2);
        assertNotNull(categoryResponse2.getCategoryId());
        ProductRequestDTO productRequestDTO2 = new ProductRequestDTO();
        productRequestDTO2.setProductName("foods");
        productRequestDTO2.setProductDescription("beans, 25kg");
        productRequestDTO2.setProductPrice(45000);
        productRequestDTO2.setProductQuantity(6);
        productRequestDTO2.setProductImageUrl("beans.jpg");
        productRequestDTO2.setDiscountedPrice(7200);
        ProductResponseDTO responseDTO1 = productService.addProduct(categoryResponse2.getCategoryId(), productRequestDTO2);
        assertNotNull(responseDTO1);
        assertEquals(2, productRepository.count());
    }




}