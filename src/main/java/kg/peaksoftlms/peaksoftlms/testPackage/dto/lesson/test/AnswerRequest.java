package kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test;

import kg.peaksoftlms.peaksoftlms.db.enums.EQuestionType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AnswerRequest {

    private Long questionId;
    private EQuestionType eQuestionType;
    private List<String> correctAnswerList;
}
