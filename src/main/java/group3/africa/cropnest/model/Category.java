package group3.africa.cropnest.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;
    private String description;
  
    @NotBlank
    @Size(min = 5, message = "Category name must contain atleast 5 letters")
    private String categoryName;


    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public @NotBlank @Size(min = 5, message = "Category name must contain atleast 5 letters") String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(@NotBlank @Size(min = 5, message = "Category name must contain atleast 5 letters") String categoryName) {
        this.categoryName = categoryName;
    }
}
