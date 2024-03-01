package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.StatoFattura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StatiFatturaDAO extends JpaRepository<StatoFattura, UUID> {
   public Page<StatoFattura> findByNomeStatoFattura(String nomeStatoFattura, Pageable pageable);

}
