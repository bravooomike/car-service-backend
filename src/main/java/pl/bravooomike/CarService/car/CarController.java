package pl.bravooomike.CarService.car;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/carService")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @GetMapping(path = "/{id}")
    public CarDto getCar(@PathVariable("id") Integer id) throws Exception{
        return carService.getCar(id);
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public CarDto addCar(@RequestBody CarDto carDto) {
        return carService.addCar(carDto);
    }

    @PutMapping(path = "/{id}")
    public CarDto updateCar(@RequestBody CarDto carDto, @PathVariable("id") Integer id) throws Exception {
        return carService.updateCar(carDto, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCar(@PathVariable("id") Integer id) throws Exception {
        carService.deleteCar(id);
    }

}
