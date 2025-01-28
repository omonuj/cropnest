package group3.africa.cropnest.repository;

import group3.africa.cropnest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
