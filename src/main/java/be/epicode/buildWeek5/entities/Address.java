package be.epicode.buildWeek5.entities;


import be.epicode.buildWeek5.enums.AddressType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

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
    private UUID id;
    private String street;
    private int number;
    private int postalCode;

    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Address(String street, int number, int postalCode, Municipality municipality, AddressType addressType) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.municipality = municipality;
        this.addressType = addressType;
    }

    public Address(String street, int number, int postalCode, AddressType addressType) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.addressType = addressType;
    }
}
