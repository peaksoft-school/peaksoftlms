package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Option {
    @Id
    private Long id;
    private String optionContent;
    private boolean isCorrectAnswer;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
