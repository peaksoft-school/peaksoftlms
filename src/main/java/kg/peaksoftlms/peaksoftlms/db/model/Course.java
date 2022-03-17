package kg.peaksoftlms.peaksoftlms.db.model;

import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.Lesson;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    private String description;
    private String img;
    private int price;

    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    //private LocalDate dateOfCreate ;
    //private Date dateOfCreate = new Date();

    @ManyToMany()
    @JoinTable(name = "courses_teacher",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teacher;

    @OneToMany
    private List<Lesson> lesson;

    public void setTeacher(Teacher teacher) {
        if (this.teacher == null) {
            this.teacher = new ArrayList<>();
        }
        this.teacher.add(teacher);
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }
}
