package kg.peaksoftlms.peaksoftlms.db.model.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Entity  @Table
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Lesson {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String lessonName;
    @OneToMany(mappedBy ="lesson",cascade = ALL)
    private List<Test> tests;
    @OneToMany(mappedBy = "lesson",cascade = ALL)
    private List<Task> tasks;
    @OneToMany(mappedBy = "lesson",cascade = ALL)
    private List<Video> videos;
    @OneToMany(mappedBy = "lesson",cascade = ALL)
    private List<Presentation> presentations;
    private String link;

//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
}
