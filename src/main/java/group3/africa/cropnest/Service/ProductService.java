package group3.africa.cropnest.Service;


import group3.africa.cropnest.Dtos.ProductRequestDTO;
import group3.africa.cropnest.Dtos.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO addProduct(Long categoryId, ProductRequestDTO productRequestDTO);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProductById(Long id, ProductRequestDTO productRequestDTO);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO deleteProductById(Long id);
}
