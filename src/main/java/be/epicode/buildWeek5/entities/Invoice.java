package be.epicode.buildWeek5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue
    @Column(name = "invoice_number")
    private int id;
    private LocalDate date;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State invoiceState;

    public Invoice(LocalDate date, double amount, Customer customer, State invoiceState) {
        this.date = date;
        this.amount = amount;
        this.customer = customer;
        this.invoiceState = invoiceState;
    }
}
