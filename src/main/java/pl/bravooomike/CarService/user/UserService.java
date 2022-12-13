package pl.bravooomike.CarService.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bravooomike.CarService.user.exception.UserDoesNotExistException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Transactional
    public List<UserDto> getUsers() {
        return userConverter.toDtos(userRepository.findAll());
    }

    @Transactional
    public UserDto getUser(Integer id) throws Exception {
        return userConverter.toDto(findUserById(id));
    }

    @Transactional
    public UserDto saveUser(UserDto userDto) {
        return userConverter.toDto(userRepository.save(userConverter.toEntity(userDto)));
    }

    @Transactional
    public UserDto updateUser(UserDto userDto, Integer id) throws Exception {
        return userConverter.toDto(userRepository.save(userConverter.toEntity(userDto, findUserById(id))));
    }

    private UserEntity findUserById(Integer id) throws Exception {
        return userRepository.findById(id).orElseThrow(UserDoesNotExistException::new);
    }

}
