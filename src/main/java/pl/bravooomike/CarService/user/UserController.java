package pl.bravooomike.CarService.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/carService/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    public UserDto getUser(@PathVariable("id") Integer id) throws Exception {
        return userService.getUser(id);
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    @PutMapping(path = "/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Integer id) throws Exception {
        return userService.updateUser(userDto, id);
    }
}
