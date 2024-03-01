package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ClientiDAO extends JpaRepository<Cliente, UUID> {

    List<Cliente> findByRagioneSocialeContainingIgnoreCase(String parteNome);
    List<Cliente> findByFatturatoAnnualeGreaterThanEqual(int minFatturato);
    List<Cliente> findByDataUltimoContatto(LocalDate dataUltimoContatto);
    List<Cliente> findByDataInserimento(LocalDate dataInserimento);



}
