package kg.peaksoftlms.peaksoftlms.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
@ToString
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    @Email(message = "Cannot be empty")
    @Column(unique = true)
    private String email;
    @JsonProperty
    private String password;

    @ManyToMany(fetch = EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roleList;

    public User(@Email(message = "Cannot be empty") String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(@Email(message = "Cannot be empty") String email, String password, List<Role> roleList) {
        this.email = email;
        this.password = password;
        this.roleList = roleList;
    }

    public User() {
    }

    public void setRole(Role role) {
        if (roleList == null) {
            roleList = new ArrayList<>();
        }
        roleList.add(role);
    }
    public void setRole(List<Role> roleList) {
        this.roleList = roleList;
    }


}
