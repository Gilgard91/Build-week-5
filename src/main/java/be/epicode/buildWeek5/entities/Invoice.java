package be.epicode.buildWeek5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate date;
    private double amount;
    @Column(name = "invoice_number")
    private int invoiceNumber;
    @ManyToOne
    @JoinColumn(name = "state_id")
    private State invoiceState;
    //@ManyToOne
    //@JoinColumn(name = "client_id")
    //private Client clientId;


    public Invoice(LocalDate date, double amount, int invoiceNumber, State invoiceState  /*, Client clientId*/) {
        this.date = date;
        this.amount = amount;
        this.invoiceNumber = invoiceNumber;
        this.invoiceState = invoiceState;
        //this.clientId = clientId;
    }
}
