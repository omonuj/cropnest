package group3.africa.cropnest.Service;


import group3.africa.cropnest.Dtos.Request.ProductRequestDTO;
import group3.africa.cropnest.Dtos.Response.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO addProduct(Long categoryId, ProductRequestDTO productRequestDTO);
}
