package be.epicode.buildWeek5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "adress")
public class Address {
    @Id
    @GeneratedValue
    private UUID id;
}
