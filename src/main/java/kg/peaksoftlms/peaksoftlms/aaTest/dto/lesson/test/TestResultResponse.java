package kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test;

import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Answer;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
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
