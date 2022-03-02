package kg.peaksoftlms.peaksoftlms.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "students")
@Builder
@ToString
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @NotBlank(message = "Have to define first name for the student")
    private String firstName;
    //    @NotBlank(message = "Have to define last name for the student")
    private String lastName;
    //    @NotBlank(message = "Have to define a phone number for the student")
    private String phoneNumber;
    @Email(message = "you must define '@' in email address")
    @Column(unique = true)
    private String email;
    @JsonProperty
    private String password;
    private String img;

    @CreatedDate
    @CreationTimestamp
    private LocalDate localDate;

    @ManyToMany(mappedBy = "students", cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Group> groups;

    @OneToOne(fetch = FetchType.EAGER, cascade = ALL)
    private User user;

    public Student() {
    }
}
