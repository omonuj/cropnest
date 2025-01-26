package group3.africa.cropnest.Utils;

import group3.africa.cropnest.dto.ProductResponseDTO;
import group3.africa.cropnest.model.Product;
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




