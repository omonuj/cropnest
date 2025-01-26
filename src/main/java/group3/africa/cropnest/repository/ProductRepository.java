package group3.africa.cropnest.repository;

import group3.africa.cropnest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    Optional<Product> findById(Long id);
}
