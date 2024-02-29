package be.epicode.buildWeek5.entities;

import be.epicode.buildWeek5.enums.ClientType;
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
    private String phone;
    private String emailContact;
    private String nameContact;
    private String surnameContact;
    private String phoneContact;
    private String businessLogo;
    private ClientType clientType;

    @OneToOne
    @JoinColumn(name = "indirizzo_sede_operativa_id")
    private Address indirizzoSedeOperativa;

    @OneToOne
    @JoinColumn(name = "indirizzo_sede_legale_id")
    private Address indirizzoSedeLegale;

    @OneToMany
    private List<Invoice> invoices = new ArrayList<>();

    public Customer(String businessName, String vatNumber, String email, LocalDate sertionDate, LocalDate dateLastContact,
                    int annualTurnover, String pec, String phone, String emailContact, String nameContact, String surnameContact,
                    String phoneContact, String businessLogo, ClientType clientType, Address indirizzoSedeOperativa, Address indirizzoSedeLegale) {
        this.businessName = businessName;
        this.vatNumber = vatNumber;
        this.email = email;
        this.sertionDate = sertionDate;
        this.dateLastContact = dateLastContact;
        this.annualTurnover = annualTurnover;
        this.pec = pec;
        this.phone = phone;
        this.emailContact = emailContact;
        this.nameContact = nameContact;
        this.surnameContact = surnameContact;
        this.phoneContact = phoneContact;
        this.businessLogo = businessLogo;
        this.clientType = clientType;
        this.indirizzoSedeOperativa = indirizzoSedeOperativa;
        this.indirizzoSedeLegale = indirizzoSedeLegale;
    }


    //    public void setAnnualTurnover(int annualTurnover, int annualTurnoverCRDTO) {
//        this.annualTurnover = annualTurnoverCRDTO;
//        if (annualTurnoverCRDTO == 0) {
//            this.annualTurnover = annualTurnover;
//        }
//    }
//
//    public void setVatNumber(String vatNumber, String vatNumberCRDTO) {
//        this.vatNumber = vatNumberCRDTO;
//        if (Objects.equals(vatNumberCRDTO, "")) {
//            this.vatNumber = vatNumber;
//        }
//    }
//
//    public void setPec(String nameContactpecCRDTO, String surnameContactpecCRDTO, String pecCRDTO) {
//        this.pec = pecCRDTO;
//        if (Objects.equals(pecCRDTO, null)) {
//            this.pec = nameContactpecCRDTO + surnameContactpecCRDTO + "@pec.it";
//        }
//    }
//
//    public void setPhone(int phoneCRDTO) {
//        this.phone = phoneCRDTO;
//        if (phoneCRDTO == 0) {
//            this.phone = new Random().nextInt(300000000, 399999999);
//        }
//    }
//
//    public void setPhoneContact(int phoneContactCRDTO) {
//        this.phoneContact = phoneContactCRDTO;
//        if (phoneContactCRDTO == 0) {
//            this.phoneContact = getPhone();
//        }
//    }
}
