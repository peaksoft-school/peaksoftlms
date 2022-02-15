package kg.peaksoftlms.peaksoftlms.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String name;
    @NotNull(message = "date of create is required!")
    private LocalDate dateOfCreate;
    @NotBlank(message = "you must write description!")
    private String description;
    @ManyToMany(fetch = EAGER, cascade = ALL)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "groups_student")
    private List<Student> students;
    @OneToMany(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Course> courses;
}
