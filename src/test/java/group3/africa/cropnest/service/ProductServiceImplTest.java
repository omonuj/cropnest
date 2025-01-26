package group3.africa.cropnest.service;

import group3.africa.cropnest.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductRepository productRepository;



    @BeforeEach
    void setUp() {
        productRepository.deleteAll();
    }


    @Test
    void test_addProduct_that_crops_can_be_added() {
        categoryId = 1L;

    }



    @Test
    void getProductById() {
    }

    @Test
    void updateProductById() {
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void deleteProductById() {
    }
}