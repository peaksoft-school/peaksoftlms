package kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test;


import kg.peaksoftlms.peaksoftlms.db.model.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TestResult {

    @Id
    @SequenceGenerator(
            name = "test_result_sequence",
            sequenceName = "test_result_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "test_result_sequence"
    )
    private Long id;

    @Column(name = "correct_answer")
    private double correctAnswers;
    @Column(name = "incorrect_answer")
    private double incorrectAnswers;
    @Column(name = "percent_of_result")
    private String resultInPercent;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(cascade = ALL, fetch = EAGER, mappedBy = "testResult")
    @Fetch(FetchMode.SUBSELECT)
    private List<Answer> answerList;

    public void setAnswerList(Answer answer) {
        if (answerList == null) {
            answerList = new ArrayList<>();
        }
        answerList.add(answer);
        answer.setTestResult(this);
    }

    public TestResult(Long id, int correctAnswers, int incorrectAnswers, String resultInPercent, Test test, Student student) {
        this.id = id;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
        this.resultInPercent = resultInPercent;
        this.test = test;
        this.student = student;
    }
}
