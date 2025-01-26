package group3.africa.cropnest.dto;

import group3.africa.cropnest.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    private String productName;
    private String productDescription;
    private double productPrice;
    private String productImageUrl;
    private double discountedPrice;
    private Integer productQuantity;

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    private Category categoryId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }




//    public ProductRequestDTO(String productName, String productDescription, double productPrice, String productImageUrl, double discountedPrice, Integer productQuantity) {
//        this.productName = productName;
//        this.productDescription = productDescription;
//        this.productPrice = productPrice;
//        this.productImageUrl = productImageUrl;
//        this.discountedPrice = discountedPrice;
//        this.productQuantity = productQuantity;
//    }
}
