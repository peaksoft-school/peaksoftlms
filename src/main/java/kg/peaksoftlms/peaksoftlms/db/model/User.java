package kg.peaksoftlms.peaksoftlms.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity @Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Email(message = "Cannot be empty")
    private String email;
    @JsonProperty
    private String password;

    @ManyToMany(fetch = EAGER, cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Role> role;

//    private Course course;
//    private String group;


    public User(@Email(message = "Cannot be empty") String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(@Email(message = "Cannot be empty") String email, String password, List<Role> role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
