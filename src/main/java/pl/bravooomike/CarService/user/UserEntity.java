package pl.bravooomike.CarService.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class UserEntity {

    @Id
    @SequenceGenerator(
            name = "userEntityIdSequence",
            sequenceName = "user_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(generator = "userEntityIdSequence")
    @Column(name = "id")
    private Integer id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="email")
    private String email;

    @Column(name ="password")
    private String password;

    @Column(name ="role")
    private String userRole;

    @Column(name ="user_name")
    private String userName;
}
