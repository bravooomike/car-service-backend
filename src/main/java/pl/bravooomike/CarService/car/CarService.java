package pl.bravooomike.CarService.car;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bravooomike.CarService.car.exception.CarDoesNotExistException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    @Transactional
    public List<CarDto> getCars() {
        return carConverter.toDtos(carRepository.findAll());
    }

    @Transactional
    public CarDto getCar(Integer id) throws Exception {
        return carConverter.toDto(findCarById(id));
    }

    @Transactional
    public CarDto saveCar(CarDto carDto) {
        return carConverter.toDto(carRepository.save(carConverter.toEntity(carDto)));
    }

    @Transactional
    public CarDto updateCar(CarDto carDto, Integer id) throws Exception {
        return carConverter.toDto(carRepository.save(carConverter.toEntity(carDto, findCarById(id))));
    }

    @Transactional
    public void deleteCar(Integer id) throws Exception {

        if (findCarById(id) == null) {
            throw new CarDoesNotExistException();
        } else {
            carRepository.deleteById(id);
        }
    }

    private CarEntity findCarById(Integer id) throws Exception {
        return carRepository.findById(id).orElseThrow(CarDoesNotExistException::new);
    }
}
