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
@Table(name = "fatture")
public class Fattura {
    @Id
    @GeneratedValue
    @Column(name = "numero")
    private int id;
    private LocalDate data;
    private double importo;

    @ManyToOne
    @JoinColumn(name = "clienti_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "stati_fattura_id")
    private StatoFattura statoFattura;

    public Fattura(LocalDate data, double importo, Cliente cliente, StatoFattura statoFattura) {
        this.data = data;
        this.importo = importo;
        this.cliente = cliente;
        this.statoFattura = statoFattura;
    }
}
