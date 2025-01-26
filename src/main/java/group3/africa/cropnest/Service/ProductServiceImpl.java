package group3.africa.cropnest.Service;

import group3.africa.cropnest.Dtos.ProductRequestDTO;
import group3.africa.cropnest.Dtos.ProductResponseDTO;
import group3.africa.cropnest.Repository.ProductRepository;
import group3.africa.cropnest.model.Category;
import group3.africa.cropnest.model.Product;
import group3.africa.cropnest.Exceptions.CategoryNotFoundException;
import group3.africa.cropnest.Utils.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public ProductResponseDTO addProduct(Long categoryId, ProductRequestDTO productRequestDTO) {
        try {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new CategoryNotFoundException("Category with this Id Not Found"));

            Product product = new Product();
//          product.setCategory(category);
            product.setProductName(productRequestDTO.getProductName());
            product.setProductDescription(productRequestDTO.getProductDescription());
            product.setProductPrice(productRequestDTO.getProductPrice());
            product.setProductImageUrl(productRequestDTO.getProductImageUrl());
            product.setProductQuantity(productRequestDTO.getProductQuantity());
            product.setDiscountedPrice(productRequestDTO.getDiscountedPrice());
            Product savedProduct = productRepository.save(product);
            return productMapper.toProductResponseDTO(savedProduct);

        } catch (CategoryNotFoundException e) {
            throw e;

        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while adding the product", e);
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
