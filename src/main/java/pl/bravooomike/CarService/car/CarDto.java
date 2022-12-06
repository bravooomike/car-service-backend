package pl.bravooomike.CarService.car;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {

    private Integer id;
    private String brand;
    private String model;
}
