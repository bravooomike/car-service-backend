package pl.bravooomike.CarService.user.exception;

import javax.xml.bind.ValidationException;

import static pl.bravooomike.CarService.user.exception.UserErrorMessage.USER_DOES_NOT_EXIST;

public class UserDoesNotExistException extends ValidationException {

    private static final String ERROR_MESSAGE = USER_DOES_NOT_EXIST;

    public UserDoesNotExistException() {
        super(ERROR_MESSAGE);
    }
}
