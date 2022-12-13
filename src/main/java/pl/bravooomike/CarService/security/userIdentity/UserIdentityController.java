package pl.bravooomike.CarService.security.userIdentity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest/carService/auth")
@RequiredArgsConstructor
public class UserIdentityController {

    private final UserIdentityProviderImplementation userIdentityProviderImpl;

    @GetMapping
    public UserIdentityDto getIdentity() {
        return userIdentityProviderImpl.getUserIdentityEntity();
    }
}
