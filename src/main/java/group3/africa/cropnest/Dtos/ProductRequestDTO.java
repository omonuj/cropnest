package group3.africa.cropnest.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImageUrl;
    private double discountedPrice;
    private Integer productQuantity;
    //    private Category categoryName;


    public ProductRequestDTO(String productName, String productDescription, double productPrice, String productImageUrl, double discountedPrice, Integer productQuantity) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;
        this.discountedPrice = discountedPrice;
        this.productQuantity = productQuantity;
    }
}
