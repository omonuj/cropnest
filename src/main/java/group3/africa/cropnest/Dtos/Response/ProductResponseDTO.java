package group3.africa.cropnest.Dtos.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Long productId;
    private String productName;
    private String description;
    private Double price;
    private String image;
    private Double discountedPrice;

    public ProductResponseDTO(Long productId, String productName, String description, Double price, String image, Double discountedPrice) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.discountedPrice = discountedPrice;
    }
}
