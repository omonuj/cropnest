package group3.africa.cropnest.repository;

import group3.africa.cropnest.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
