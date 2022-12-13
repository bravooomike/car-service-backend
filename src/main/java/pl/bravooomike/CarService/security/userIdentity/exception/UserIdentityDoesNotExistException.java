package pl.bravooomike.CarService.security.userIdentity.exception;

import org.springframework.security.core.AuthenticationException;

import static pl.bravooomike.CarService.security.userIdentity.exception.UserIdentityErrorMessage.USER_IDENTITY_DOES_NOT_EXIST;

public class UserIdentityDoesNotExistException extends AuthenticationException {

    private static final String ERROR_MESSAGE = USER_IDENTITY_DOES_NOT_EXIST;

    public UserIdentityDoesNotExistException() {
        super(ERROR_MESSAGE);
    }
}
