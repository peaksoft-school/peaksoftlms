package kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test.AnswerRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test.TestResultResponse;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.Answer;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;

public interface AnswerService {
    Answer saveAnswer(Answer answer);
    TestResultResponse saveAnswers(List<AnswerRequest> answerRequestList, User user, Long id);
    Answer findAnswerById(Long id);
}
