package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<Address, Integer> {
}
