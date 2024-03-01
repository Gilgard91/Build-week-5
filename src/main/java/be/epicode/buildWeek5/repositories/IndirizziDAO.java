package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizziDAO extends JpaRepository<Indirizzo, Integer> {
}
