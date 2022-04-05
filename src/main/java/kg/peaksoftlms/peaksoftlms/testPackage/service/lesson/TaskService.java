package kg.peaksoftlms.peaksoftlms.testPackage.service.lesson;

import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.TaskRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllByLessonId(Long lessonId);

    TaskResponse getById(Long id);

    TaskResponse saveTask(TaskRequest taskRequest, Long lessonId);

    void deleteById(Long id);

    TaskResponse updateTask(Long id, TaskRequest taskRequest, Long lessonId);
}
