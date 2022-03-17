package kg.peaksoftlms.peaksoftlms.aaTest.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test.AnswerRequest;
import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test.TestResultResponse;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Answer;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.TestResult;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;

public interface AnswerService {
    Answer saveAnswer(Answer answer);
    TestResultResponse saveAnswers(List<AnswerRequest> answerRequestList, User user, Long id);
//    Answer answerRequestToAnswer(AnswerRequest answerRequest);
    Answer findAnswerById(Long id);
}
