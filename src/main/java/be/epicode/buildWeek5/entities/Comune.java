package be.epicode.buildWeek5.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "comuni")
public class Comune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false)
    private Provincia provincia;

    public Comune(String nome, Provincia provincia) {
        this.provincia = provincia;
        this.nome = nome;

    }

//    public Municipality(String name, String provinceCode) {
//        this.name = name;
//        ProvinceCode = provinceCode;
//    }
//
//    public Municipality(String name, String provinceCode, Province province) {
//        this.name = name;
//        ProvinceCode = provinceCode;
//        this.province = province;
//    }
}
