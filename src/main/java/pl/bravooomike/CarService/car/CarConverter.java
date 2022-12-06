package pl.bravooomike.CarService.car;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
//@RequiredArgsConstructor
public class CarConverter {

    public CarDto toDto(CarEntity carEntity) {
        return CarDto.builder()
                .id(carEntity.getId())
                .brand(carEntity.getBrand())
                .model(carEntity.getModel())
                .build();
    }

    public List<CarDto> toDtos(List<CarEntity> carEntities) {
        return carEntities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public CarEntity toEntity(CarDto carDto, CarEntity previousCarEntity) {

        CarEntity carEntity;

        if (previousCarEntity == null) {
            carEntity = new CarEntity();
        } else {
            carEntity = previousCarEntity;
        }

        carEntity.setBrand(carDto.getBrand());
        carEntity.setModel(carDto.getModel());
        return carEntity;
    }

    public CarEntity toEntity(CarDto carDto) {
        return toEntity(carDto, null);
    }
}
