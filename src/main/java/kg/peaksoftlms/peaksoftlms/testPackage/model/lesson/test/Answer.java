package kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.peaksoftlms.peaksoftlms.db.enums.EQuestionType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "answer_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Answer {

    @Id
    @SequenceGenerator(
            name = "answer_sequence",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_sequence"
    )
    private Long id;

    @ElementCollection()
    @CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "user_answers")
    private List<String> answers;

    @ManyToOne(cascade = {MERGE, PERSIST, REFRESH, DETACH})
    @JoinColumn(name = "question_id")
    private Question question;

    @Enumerated(EnumType.STRING)
    private EQuestionType eQuestionType;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "test_result_id")
    @JsonIgnore
    private TestResult testResult;
}