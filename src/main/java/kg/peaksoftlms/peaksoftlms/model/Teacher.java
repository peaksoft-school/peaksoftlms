package kg.peaksoftlms.peaksoftlms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.peaksoftlms.peaksoftlms.model.course.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Entity @Table
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Teacher {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Have to create new responsible person")
    private String teacherName;
    @NotBlank (message = "Have to write last name")
    private String teacherLastName;
    @Email (message = "wrong E-mail address, please check it again")
    private String teacherEmail;
    @JsonProperty
    private String password;
    private String teacherImg;
    @NotNull(message = "date of create is required!")
    private LocalDate dateOfCreate;
    @ManyToMany
    @JoinColumn(name = "id")
    private List<Course> course;
}
