package be.epicode.buildWeek5.entities;

import be.epicode.buildWeek5.enums.TipoCliente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clienti")
public class Cliente {
    @Id
    @GeneratedValue
    private UUID id;
    private String ragioneSociale;
    private String partitaIva;
    private String email;
    private LocalDate dataInserimento;
    private LocalDate dataUltimoContatto;
    private int fatturatoAnnuale;
    private String pec;
    private String telefono;
    private String emailContatto;
    private String nomeContatto;
    private String cognomeContatto;
    private String telefonoContatto;
    private String logoAziendale;
    private TipoCliente tipoCliente;

    @OneToOne
    @JoinColumn(name = "indirizzo_sede_operativa_id")
    private Indirizzo indirizzoSedeOperativa;

    @OneToOne
    @JoinColumn(name = "indirizzo_sede_legale_id")
    private Indirizzo indirizzoSedeLegale;

    @OneToMany
    private List<Fattura> fatture = new ArrayList<>();

    public Cliente(String ragioneSociale, String partitaIva, String email, LocalDate dataInserimento, LocalDate dataUltimoContatto, int fatturatoAnnuale,
                   String pec, String telefono, String emailContatto, String nomeContatto, String cognomeContatto, String telefonoContatto, String logoAziendale,
                   TipoCliente tipoCliente, Indirizzo indirizzoSedeOperativa, Indirizzo indirizzoSedeLegale) {
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
        this.email = email;
        this.dataInserimento = dataInserimento;
        this.dataUltimoContatto = dataUltimoContatto;
        this.fatturatoAnnuale = fatturatoAnnuale;
        this.pec = pec;
        this.telefono = telefono;
        this.emailContatto = emailContatto;
        this.nomeContatto = nomeContatto;
        this.cognomeContatto = cognomeContatto;
        this.telefonoContatto = telefonoContatto;
        this.logoAziendale = logoAziendale;
        this.tipoCliente = tipoCliente;
        this.indirizzoSedeOperativa = indirizzoSedeOperativa;
        this.indirizzoSedeLegale = indirizzoSedeLegale;
    }

}
