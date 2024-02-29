package be.epicode.buildWeek5.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private int id;
    private String street;
    private int number;
    private int postalCode;

    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

//    @Enumerated(EnumType.STRING)
//    private AddressType addressType;

    public Address(String street, int number, int postalCode, Municipality municipality) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.municipality = municipality;
//        this.addressType = addressType;
    }

//    public Address(String street, int number, int postalCode, AddressType addressType) {
//        this.street = street;
//        this.number = number;
//        this.postalCode = postalCode;
//        this.addressType = addressType;
//    }
}
