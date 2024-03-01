package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Fattura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FattureDAO extends JpaRepository<Fattura, UUID> {
//    public Page<Invoice> findInvoiceByDate(LocalDate date, Pageable pageable);
//    @Query("SELECT i FROM Invoice i WHERE YEAR(i.date) = :year")
//    public Page<Invoice> findInvoiceByYear(@Param("year") int year, Pageable pageable);
//    @Query("SELECT i FROM Invoice i WHERE i.amount BETWEEN :minAmount AND :maxAmount")
//    public Page<Invoice> findInvoicesByAmountRange(@Param("minAmount") double minAmount, @Param("maxAmount") double maxAmount, Pageable pageable);
//    public Page<Invoice> findByInvoiceState(State state, Pageable pageable);
//   public Page<Invoice> findByCustomer(Customer customer, Pageable pageable);



}
