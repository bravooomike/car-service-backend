package pl.bravooomike.CarService.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserDto toDto(UserEntity userEntity) {

        return UserDto.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .userRole(userEntity.getUserRole())
                .userName(userEntity.getUserName())
                .build();
    }

    public List<UserDto> toDtos(List<UserEntity> userEntities) {

        return userEntities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserEntity toEntity(UserDto userDto, UserEntity previousUserEntity) {

        previousUserEntity.setFirstName(userDto.getFirstName());
        previousUserEntity.setLastName(userDto.getLastName());
        previousUserEntity.setEmail(userDto.getEmail());
        previousUserEntity.setPassword(userDto.getPassword());
        previousUserEntity.setUserRole(userDto.getUserRole());
        previousUserEntity.setUserName(userDto.getUserName());
        return previousUserEntity;
    }

    public UserEntity toEntity(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setUserRole(userDto.getUserRole());
        userEntity.setUserName(userDto.getUserName());
        return userEntity;
    }
}
