package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerDAO extends JpaRepository<Customer, UUID> {
}
