package kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test;

import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.Answer;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TestResultResponse {

    private long id;
    private double correctAnswers;
    private double incorrectAnswers;
    private String resultInPercent;

    private Student student;
    private List<Answer> answerList;

}
