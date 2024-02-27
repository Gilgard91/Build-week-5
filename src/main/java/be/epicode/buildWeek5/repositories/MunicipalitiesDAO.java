package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipalitiesDAO extends JpaRepository<Municipality, Long> {
    Municipality findByName(String name);
}
