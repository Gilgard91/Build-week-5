package be.epicode.buildWeek5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private UUID id;
    private String businessName;
    private String vatNumber;
    private String email;
    private LocalDate sertionDate;
    private LocalDate dateLastContact;
    private int annualTurnover;
    private String pec;
    private int phone;
    private String emailContact;
    private String nameContact;
    private String surnameContact;
    private int phoneContact;
    private String businessLogo;
    private ClientType clientType;

    @OneToOne
    @JoinColumn(name = "address_id")
private Address address;

    @OneToMany
    @JoinColumn(name = "invoices_id")
    private List <Invoice> invoice = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setAnnualTurnover(int annualTurnover, int annualTurnoverCRDTO) {
        this.annualTurnover = annualTurnoverCRDTO;
        if (annualTurnoverCRDTO == 0) {
            this.annualTurnover = annualTurnover;
        }
    }

    public void setVatNumber(String vatNumber, String vatNumberCRDTO) {
        this.vatNumber = vatNumberCRDTO;
        if (Objects.equals(vatNumberCRDTO, "")) {
            this.vatNumber = vatNumber;
        }
    }

    public void setPec(String nameContactpecCRDTO,String surnameContactpecCRDTO, String pecCRDTO) {
        this.pec = pecCRDTO;
        if (Objects.equals(pecCRDTO, null)) {
            this.pec = nameContactpecCRDTO + surnameContactpecCRDTO + "@pec.it";
        }
    }
}
