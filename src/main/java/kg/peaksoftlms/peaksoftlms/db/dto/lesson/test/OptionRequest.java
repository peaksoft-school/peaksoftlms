package kg.peaksoftlms.peaksoftlms.db.dto.lesson.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OptionRequest {
    private String optionContent;
    private boolean isCorrectAnswer;
}
