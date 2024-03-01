package be.epicode.buildWeek5.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "stati_fattura")
public class StatoFattura {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "nome_stato")
    private String nomeStatoFattura;


    public StatoFattura(String nomeStatoFattura) {
        this.nomeStatoFattura = nomeStatoFattura;
    }
}
