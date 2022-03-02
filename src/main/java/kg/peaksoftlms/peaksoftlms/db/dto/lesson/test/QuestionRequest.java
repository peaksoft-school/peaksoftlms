package kg.peaksoftlms.peaksoftlms.db.dto.lesson.test;

import kg.peaksoftlms.peaksoftlms.db.enums.EQuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class QuestionRequest {
    private String question;
    private EQuestionType eQuestionType;
    private List<OptionRequest> optionRequestList;
}
