package kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OptionRequest {

    private String optionContent;
    private Boolean isCorrect;
}
