package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceDAO extends JpaRepository<Provincia, Long> {
//    Province findByName(String name);
//    Province findByCode(String code);

    @Query("SELECT p FROM Provincia p WHERE p.nome = :nomeProvincia")
    Provincia findProvinceByNome(@Param("nomeProvincia") String nomeProvincia);

}
