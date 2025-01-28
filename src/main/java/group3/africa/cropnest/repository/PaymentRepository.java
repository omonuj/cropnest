package group3.africa.cropnest.repository;

import group3.africa.cropnest.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
