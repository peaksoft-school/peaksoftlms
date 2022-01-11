package kg.peaksoftlms.peaksoftlms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
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
    @Email(message = "Cannot be empty")
    private String email;
    @JsonProperty
    private String password;
    @ManyToMany(fetch = EAGER, cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Role> role;
//    private Course course;
//    private String group;
}
