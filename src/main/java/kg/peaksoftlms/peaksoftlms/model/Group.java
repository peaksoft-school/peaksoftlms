package kg.peaksoftlms.peaksoftlms.model;

import kg.peaksoftlms.peaksoftlms.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity @Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull(message = "date of create is required!")
    private LocalDate dateOfCreate;
    @NotBlank(message = "you must write description!")
    private String description;
//    @OneToMany(fetch = EAGER, cascade = {DETACH, MERGE, PERSIST, REFRESH})
//    private List<Student> stedents;
    @OneToMany
    private List<Course> courses;
}
