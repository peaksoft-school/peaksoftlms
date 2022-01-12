package kg.peaksoftlms.peaksoftlms.model.course.lesson;

import kg.peaksoftlms.peaksoftlms.model.course.lesson.Video;
import kg.peaksoftlms.peaksoftlms.model.course.lesson.Presentation;
import kg.peaksoftlms.peaksoftlms.model.course.lesson.Task;
import kg.peaksoftlms.peaksoftlms.model.course.lesson.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.FetchType.EAGER;

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
    @OneToMany(mappedBy ="lesson")
    private List<Test> tests;
    @OneToMany(mappedBy = "lesson")
    private List<Task> tasks;
    @OneToMany(mappedBy = "lesson")
    private List<Video> videos;
    @OneToMany(mappedBy = "lesson")
    private List<Presentation> presentations;
    private String link;

//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    private Course course;
}
