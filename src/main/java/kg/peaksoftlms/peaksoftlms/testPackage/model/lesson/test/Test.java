package kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "idActive")
    private boolean isActive;

    @OneToMany(cascade = ALL, fetch = FetchType.EAGER, mappedBy = "test")
    @Fetch(FetchMode.SUBSELECT)
    private List<Question> questionList;

    @ManyToOne(fetch = LAZY, cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "lesson_id")
    @JsonIgnore
    private Lesson lesson;

    @OneToMany(cascade = ALL, mappedBy = "test")
    @Fetch(FetchMode.SUBSELECT)
    @JsonIgnore
    private List<TestResult> testResult;

    public void addQuestionForTest(Question question) {
        if (questionList == null) {
            questionList = new ArrayList<>();
        }
        questionList.add(question);
        question.setTest(this);
    }
}
