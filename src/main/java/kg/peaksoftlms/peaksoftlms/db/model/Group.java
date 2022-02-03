package kg.peaksoftlms.peaksoftlms.db.model;

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
import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    // TODO: 3/2/22 define image
    @NotBlank(message = "group name is required")
    private String name;
    @NotNull(message = "date of create is required!")
    private LocalDate dateOfCreate;
    @NotBlank(message = "you must write description!")
    @Column(length = 10000)
    private String description;
    @OneToMany(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    private List<Course> courses;
}
