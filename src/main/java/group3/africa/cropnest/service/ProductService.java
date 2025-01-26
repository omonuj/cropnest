package group3.africa.cropnest.service;


import group3.africa.cropnest.dto.ProductRequestDTO;
import group3.africa.cropnest.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO addProduct(Long categoryId, ProductRequestDTO productRequestDTO);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProductById(Long id, ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO deleteProductById(Long id);
}
