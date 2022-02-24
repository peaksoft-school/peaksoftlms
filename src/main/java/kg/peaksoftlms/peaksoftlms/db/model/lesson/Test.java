package kg.peaksoftlms.peaksoftlms.db.model.lesson;

import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

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
    private String name;
    //private Set<Question> question;
    private String answer;
    //add
    private int testMarksScored;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalTime testDuration;

    //    @OneToMany(fetch =LAZY, cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @ManyToOne
    private Lesson lesson;
}
