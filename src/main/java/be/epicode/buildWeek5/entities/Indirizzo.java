package be.epicode.buildWeek5.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "indirizzi")
public class Indirizzo {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private int id;
    private String via;
    private int civico;
    private int cap;

    @ManyToOne
    @JoinColumn(name = "comuni_id")
    private Comune comune;

    public Indirizzo(String via, int civico, int cap, Comune comune) {
        this.via = via;
        this.civico = civico;
        this.cap = cap;
        this.comune = comune;
    }

}
