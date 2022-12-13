package pl.bravooomike.CarService.security.userIdentity;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserIdentityProviderImplementation {

    public UserIdentityDto getUserIdentityEntity() {
        CustomUser principal = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return UserIdentityDto.builder()
                .id(principal.getId())
                .userName(principal.getUsername())
                .firstName(principal.getFirstName())
                .lastName(principal.getLastName())
                .email(principal.getEmail())
                .password(principal.getPassword())
                .userRole(principal.getAuthorities().toString())
                .build();
    }
}