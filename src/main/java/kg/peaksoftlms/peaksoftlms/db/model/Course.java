package kg.peaksoftlms.peaksoftlms.db.model;

import kg.peaksoftlms.peaksoftlms.db.model.lesson.Lesson;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String name;
    private String description;
    private String img;
    private int price;
    private LocalDate dateOfCreate;

    @ManyToMany
    private List<Teacher> teacher;

    @OneToMany
    private List<Lesson> lesson;
}
