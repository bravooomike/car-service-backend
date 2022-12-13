package pl.bravooomike.CarService.security.userIdentity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserIdentityDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String userRole;
    private String userName;
    private String password;
}
