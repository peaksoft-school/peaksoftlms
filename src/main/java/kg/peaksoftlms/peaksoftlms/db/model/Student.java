package kg.peaksoftlms.peaksoftlms.db.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "students")
@Builder
@ToString
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String studentImg;
    @CreatedDate
    private Date dateOfCreate = new Date();

    @ManyToMany(mappedBy = "students", cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Group> groups;

    @OneToOne(fetch = FetchType.EAGER,cascade = ALL)
    private User user;

    public Student() {
    }
}
