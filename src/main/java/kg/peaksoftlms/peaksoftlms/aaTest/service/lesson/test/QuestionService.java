package kg.peaksoftlms.peaksoftlms.aaTest.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test.QuestionRequest;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Question;

import java.util.List;

public interface QuestionService {
    Question saveQuestion(Long testId, QuestionRequest questionRequest);

    Question getById(Long id);

    List<Question> getAllByTestId(Long testId);

    void deleteById(Long id);

    Question update(Long id, QuestionRequest questionRequest, Long testId);
}
