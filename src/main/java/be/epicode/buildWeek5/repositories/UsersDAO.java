package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersDAO extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

}
