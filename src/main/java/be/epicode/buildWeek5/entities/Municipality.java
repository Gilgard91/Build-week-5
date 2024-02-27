package be.epicode.buildWeek5.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "municipalities")
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
//    private String ProvinceCode;


    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false)
    private Province province;

    public Municipality(String name, Province province ) {
        this.province = province;
        this.name = name;

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
