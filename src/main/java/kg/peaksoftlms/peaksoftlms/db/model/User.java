package kg.peaksoftlms.peaksoftlms.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email(message = "Cannot be empty")
    @Column(unique = true)
    private String email;
    @JsonProperty
    private String password;

    @ManyToMany(fetch = EAGER)
    private List<Role> role;

    public User(@Email(message = "Cannot be empty") String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(@Email(message = "Cannot be empty") String email, String password, List<Role> role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }
}
