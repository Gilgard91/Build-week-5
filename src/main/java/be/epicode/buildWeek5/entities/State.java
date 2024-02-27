package be.epicode.buildWeek5.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class State {
    @Id
    @GeneratedValue
    private UUID id;
    private String stateName;
    @OneToMany(mappedBy = "invoiceState")
    private List<Invoice> invoices;

    public State(String stateName, List<Invoice> invoices) {
        this.stateName = stateName;
        this.invoices = invoices;
    }
}
