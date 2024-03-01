package be.epicode.buildWeek5.repositories;

import be.epicode.buildWeek5.entities.Invoice;
import be.epicode.buildWeek5.entities.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface InvoiceDAO extends JpaRepository<Invoice, UUID> {
    public Page<Invoice> findInvoiceByDate(LocalDate date, Pageable pageable);
    @Query("SELECT i FROM Invoice i WHERE YEAR(i.date) = :year")
    public Page<Invoice> findInvoiceByYear(@Param("year") int year, Pageable pageable);
    @Query("SELECT i FROM Invoice i WHERE i.amount BETWEEN :minAmount AND :maxAmount")
    public Page<Invoice> findInvoicesByAmountRange(@Param("minAmount") double minAmount, @Param("maxAmount") double maxAmount, Pageable pageable);
    public Page<Invoice> findByInvoiceState(State state, Pageable pageable);

  //  public Page<Invoice> findByClient(Client client, Pageable pageable);



}
