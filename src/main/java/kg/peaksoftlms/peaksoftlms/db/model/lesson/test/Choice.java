package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Choice {
    private String label;
    private boolean isCorrectAnswer;
}
