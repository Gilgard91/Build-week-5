package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Fattura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface FattureDAO extends JpaRepository<Fattura, UUID> {

    List<Fattura> findByClienteRagioneSocialeIgnoreCase(String ragioneSociale);
    List<Fattura> findByStatoFatturaNomeStatoFatturaIgnoreCase(String statoFattura);
    List<Fattura> findByData(LocalDate data);
    List<Fattura> findByDataBetween(LocalDate inizioAnno, LocalDate fineAnno);
    List<Fattura> findByImportoBetween(double minImporto, double maxImporto);



}
