package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;

import kg.peaksoftlms.peaksoftlms.db.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int correctAnswers;
    private int incorrectAnswers;

    @OneToMany
    private List<Option> optionList;

    //private List<Long> optionId;

    @OneToOne
    private Question question;

    @ManyToOne
    private Test test;

    @ManyToMany(cascade = {MERGE, DETACH, REFRESH, PERSIST})
    @JoinTable(name = "answers_students", joinColumns = @JoinColumn(name = "answer_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> student;
}
