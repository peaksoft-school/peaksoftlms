package kg.peaksoftlms.peaksoftlms.aaTest.service.lesson;

import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.TaskRequest;
import kg.peaksoftlms.peaksoftlms.aaTest.dto.lesson.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllByLessonId(Long lessonId);

    TaskResponse getById(Long id);

    TaskResponse saveTask(TaskRequest taskRequest, Long lessonId);

    void deleteById(Long id);

    TaskResponse updateTask(Long id, TaskRequest taskRequest, Long lessonId);
}
