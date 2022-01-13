package kg.peaksoftlms.peaksoftlms.db.model;

import kg.peaksoftlms.peaksoftlms.db.model.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Entity @Table
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Course {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String description;
    private String img;
    private int price;
    private LocalDate dateOfCreate;
    @ManyToMany(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<Teacher> teacher;

    @OneToMany(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List <Lesson> lesson;



}
