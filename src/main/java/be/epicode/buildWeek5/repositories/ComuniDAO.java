package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComuniDAO extends JpaRepository<Comune, Long> {
    Comune findByNome(String nome);
}
