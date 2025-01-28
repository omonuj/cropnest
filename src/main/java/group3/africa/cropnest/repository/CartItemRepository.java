package group3.africa.cropnest.repository;

import group3.africa.cropnest.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
