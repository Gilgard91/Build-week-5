package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtentiDAO extends JpaRepository<Utente, UUID> {
    Optional<Utente> findByEmail(String email);

}
