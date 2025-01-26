package group3.africa.cropnest.service;

import group3.africa.cropnest.dto.ProductRequestDTO;
import group3.africa.cropnest.dto.ProductResponseDTO;
import group3.africa.cropnest.model.Category;
import group3.africa.cropnest.repository.CategoryRepository;
import group3.africa.cropnest.repository.ProductRepository;
import group3.africa.cropnest.model.Product;
import group3.africa.cropnest.exception.CategoryNotFoundException;
import group3.africa.cropnest.Utils.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductResponseDTO addProduct(Long categoryId, ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.findByCategoryId(categoryId)
                . orElseThrow(() -> new CategoryNotFoundException("Category with ID " + categoryId + " not found."));

        Product product = new Product();
        product.setCategoryId(category);
        product.setProductName(productRequestDTO.getProductName());
        product.setProductDescription(productRequestDTO.getProductDescription());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setProductImageUrl(productRequestDTO.getProductImageUrl());
        product.setProductQuantity(productRequestDTO.getProductQuantity());
        product.setDiscountedPrice(productRequestDTO.getDiscountedPrice());

        try {
            Product savedProduct = productRepository.save(product);
            return productMapper.toProductResponseDTO(savedProduct);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while saving the product.", e);
        }
    }





    @Override
    public ProductResponseDTO getProductById(Long id) {
        return null;
    }

    @Override
    public ProductResponseDTO updateProductById(Long id, ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductResponseDTO deleteProductById(Long id) {
        return null;
    }
}
