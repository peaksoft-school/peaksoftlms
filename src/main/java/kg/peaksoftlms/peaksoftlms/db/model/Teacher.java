package kg.peaksoftlms.peaksoftlms.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Teacher extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Have to create new responsible person")
    @Column(name = "FIRST_NAME")
    private String firstName;
    @NotBlank(message = "Have to write last name")
    @Column(name = "LAST_NAME")
    private String lastName;
    @Email(message = "wrong E-mail address, please check it again")
    private String email;
    @JsonProperty
    private String password;
    private String img;
    @NotNull(message = "date of create is required!")
    private LocalDate dateOfCreate;
    @ManyToMany(mappedBy = "teacher", cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Course> course;
    @OneToOne
    private User user;


}
