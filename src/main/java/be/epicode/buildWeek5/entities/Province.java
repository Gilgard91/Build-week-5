package be.epicode.buildWeek5.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "provinces")
public class Province {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;





    public Province(String name, String code) {
        this.name = name;
        this.code = code;

    }
}
