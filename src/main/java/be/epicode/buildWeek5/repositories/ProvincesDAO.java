package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvincesDAO extends JpaRepository<Province, Long> {
    Province findByName(String name);
    Province findByCode(String code);
}
