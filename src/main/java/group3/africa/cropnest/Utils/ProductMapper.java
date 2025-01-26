package group3.africa.cropnest.Utils;

import group3.africa.cropnest.Dtos.Response.ProductResponseDTO;
import group3.africa.cropnest.Entities.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponseDTO toProductResponseDTO(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductResponseDTO(product.getProductId(),
                product.getProductName(),
                product.getProductDescription(),
                product.getProductPrice(),
                product.getProductImageUrl(),
                product.getProductQuantity(),
                product.getProductQuantity());
    }
}




