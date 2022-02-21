package kg.peaksoftlms.peaksoftlms.service.lesson;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.TaskRequest;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.Test;

import java.util.List;

public interface TestService {
    List<Test> getAllByLessonId(Long lessonId);

    Test getById(Long id);

    Test saveNewTask(Test taskRequest, Long lessonId);

    void deleteById(Long id);

    void updateTask(Long id, TaskRequest taskRequest, Long lessonId);
}
