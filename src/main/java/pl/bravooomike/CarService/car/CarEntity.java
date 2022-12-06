package pl.bravooomike.CarService.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarEntity {

    @Id
    @SequenceGenerator(
            name = "carIdSequence",
            sequenceName = "car_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;
}
