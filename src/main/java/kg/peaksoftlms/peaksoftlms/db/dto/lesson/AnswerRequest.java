package kg.peaksoftlms.peaksoftlms.db.dto.lesson;

import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Option;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Question;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Test;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter@Setter
public class AnswerRequest {

    //private Student student;
    // private List<Option> optionList;//chosen
    private Long testId;
    private List<Long> questionId;
    private List<Long> optionId;//chosen
}
