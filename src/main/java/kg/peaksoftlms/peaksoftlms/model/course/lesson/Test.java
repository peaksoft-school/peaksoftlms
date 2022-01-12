package kg.peaksoftlms.peaksoftlms.model.course.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.FetchType.LAZY;

@Entity @Table
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Test {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String testName;
    private String question;
    private String answer;

    //    @OneToMany(fetch =LAZY, cascade = {DETACH, MERGE, PERSIST, REFRESH})
     @ManyToOne
    private Lesson lesson;
}
