package kg.peaksoftlms.peaksoftlms.service.lesson;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.TaskRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.TaskResponse;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllByLessonId(Long lessonId);

    TaskResponse getById(Long id);

    TaskResponse saveTask(TaskRequest taskRequest, Long lessonId);

    void deleteById(Long id);

    TaskResponse updateTask(Long id, TaskRequest taskRequest, Long lessonId);
}
