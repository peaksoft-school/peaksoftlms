package kg.peaksoftlms.peaksoftlms.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "teachers")
public class Teacher {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotBlank(message = "Have to create new responsible person")
    private String firstName;
//    @NotBlank(message = "Have to write last name")
    private String LastName;
    @Email(message = "wrong E-mail address, please check it again")
    private String email;
    @JsonProperty
    private String password;
    private String img;

    private int phoneNumber;
    private String specialization;

    @CreatedDate
    @CreationTimestamp
    private LocalDate dateOfCreate;

    @ManyToMany(mappedBy = "teacher", cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JsonIgnore
    private List<Course> courses;
    @OneToOne(fetch = FetchType.EAGER, cascade = ALL)
    private User user;

    public Teacher() {
    }
}
