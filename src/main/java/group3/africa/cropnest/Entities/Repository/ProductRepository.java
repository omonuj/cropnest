package group3.africa.cropnest.Entities.Repository;

import group3.africa.cropnest.Entities.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
