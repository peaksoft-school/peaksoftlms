package kg.peaksoftlms.peaksoftlms.aaTest.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.test.TestRequest;
import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Test;

import java.util.List;

public interface TestService {
    List<Test> getAllByLessonId(Long lessonId);

    Test getById(Long id);

    Test saveTest(TestRequest testRequest, Long lessonId);

    void deleteById(Long id);

    Test updateTest(Long id, TestRequest testRequest, Long lessonId);
}
