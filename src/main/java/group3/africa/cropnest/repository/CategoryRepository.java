package group3.africa.cropnest.repository;

import group3.africa.cropnest.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(@NotBlank @Size(min = 5, message = "Category name must contain atleast 5 letters") String categoryName);
    Optional<Category> findByCategoryId(@NotBlank Long categoryId);
}
