package kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test;

import kg.peaksoftlms.peaksoftlms.db.enums.EQuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuestionRequest {

    private String question;
    private EQuestionType eQuestionType;
    private List<OptionRequest> optionRequestList;

}
