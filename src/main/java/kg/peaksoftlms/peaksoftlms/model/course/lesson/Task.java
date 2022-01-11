package kg.peaksoftlms.peaksoftlms.model.course.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity @Table
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Task {
    @Id
//    @OneToMany(fetch =LAZY, cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String taskName;
    private String task;
    private String img;  //can be byte
    @ManyToOne
    private Lesson lesson;

}
