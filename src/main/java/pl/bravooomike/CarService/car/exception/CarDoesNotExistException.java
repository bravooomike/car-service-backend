package pl.bravooomike.CarService.car.exception;


import javax.xml.bind.ValidationException;

import static pl.bravooomike.CarService.car.exception.CarErrorMessage.CAR_WITH_SUCH_ID_DOES_NOT_EXIST;

public class CarDoesNotExistException extends ValidationException {

    private static final String ERROR_MESSAGE = CAR_WITH_SUCH_ID_DOES_NOT_EXIST;

    public CarDoesNotExistException() {
        super(ERROR_MESSAGE);
    }
}
