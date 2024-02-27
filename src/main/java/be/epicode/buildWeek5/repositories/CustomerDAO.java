package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CustomerDAO extends JpaRepository<Customer, UUID> {
//    List<Customer> findByLastName(String lastName);
}
