package pl.bravooomike.CarService.security.userIdentity;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.bravooomike.CarService.security.userIdentity.exception.UserIdentityDoesNotExistException;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserIdentityService {

    private final UserIdentityRepository userIdentityRepository;

    public User loadByEmail(String email, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        UserIdentityEntity userIdentityEntity = userIdentityRepository.findByEmail(email);

        boolean isPasswordEmpty = "".equals(authentication.getCredentials().toString());

        if (userIdentityEntity == null | isPasswordEmpty | isPasswordCorrect(userIdentityEntity, authentication)) {
            throw new UserIdentityDoesNotExistException();
        }

        return new CustomUser(userIdentityEntity.getUserName(),
                userIdentityEntity.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(userIdentityEntity.getUserRole())),
                userIdentityEntity.getId(),
                userIdentityEntity.getFirstName(),
                userIdentityEntity.getLastName(),
                userIdentityEntity.getEmail());
    }

    private boolean isPasswordCorrect(UserIdentityEntity userIdentityEntity,
                                      UsernamePasswordAuthenticationToken authentication) {
        if (userIdentityEntity == null) {
            throw new UserIdentityDoesNotExistException();
        }

        return !userIdentityEntity.getPassword().equals(authentication.getCredentials().toString());
    }
}
