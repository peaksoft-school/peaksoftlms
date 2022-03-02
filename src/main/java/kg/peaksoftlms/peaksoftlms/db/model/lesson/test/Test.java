package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    //private int testCodeQuantity;

    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    //private int status; // 1: active, 0: inactive

    @OneToMany
    private List<Question> questions;
    @ManyToOne(fetch = LAZY, cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JsonIgnore
    private Lesson lesson;

    public void addQuestionForTest(Question question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        questions.add(question);
        question.setTest(this);
    }
}
