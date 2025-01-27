package group3.africa.cropnest.service;


import group3.africa.cropnest.dto.ProductRequestDTO;
import group3.africa.cropnest.dto.ProductResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductService {
    ProductResponseDTO addProduct(Long categoryId, ProductRequestDTO productRequestDTO);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProductById(Long id, ProductRequestDTO productRequestDTO);
    Page<ProductResponseDTO> getAllProducts(int pageNo, int pageSize, String sortBy, String sortOrder);
    ProductResponseDTO deleteProductById(Long id);
}
