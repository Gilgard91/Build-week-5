package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateDAO extends JpaRepository<State, UUID> {
   public Page<State> findByStateName(String stateName, Pageable pageable);

}
