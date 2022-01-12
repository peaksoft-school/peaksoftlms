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
    @ManyToOne
    private Teacher teacher;

    @OneToMany
    private List <Lesson> lesson;



}
