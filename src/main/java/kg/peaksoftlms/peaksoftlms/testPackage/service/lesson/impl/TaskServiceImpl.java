package kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.impl;

import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.TaskRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.TaskResponse;
import kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.TaskService;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Lesson;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Task;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.LessonRepository;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.TaskRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import kg.peaksoftlms.peaksoftlms.testPackage.mapper.lesson.TaskMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskResponse saveTask(TaskRequest taskRequest, Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() -> {
            log.error("lesson with id = {} does not exists in database", lessonId);
            throw new ResourceNotFoundException("Not found lesson with this id: " + lessonId);
        });
        Task task = taskMapper.taskRequestToTask(taskRequest);
        task.setLesson(lesson);
        log.info("Save new task: name = {}", task.getTaskName());
        return taskMapper.taskToTaskResponse(taskRepository.save(task));
    }

    @Override
    public List<TaskResponse> getAllByLessonId(Long lessonId) {
        if (!lessonRepository.existsById(lessonId)) {
            log.error("lesson with id = {} does not exists in database", lessonId);
            throw new ResourceNotFoundException("Not found lesson with this id: " + lessonId);
        }
        log.info("Get all tasks with lesson id = {}", lessonId);
        return taskMapper.taskListToTaskResponseList(taskRepository.findByLessonId(lessonId));
    }

    @Override
    public TaskResponse getById(Long id) {
        log.info("Get task with this id = {}", id);
        return taskMapper.taskToTaskResponse(taskRepository.findById(id).orElseThrow(() -> {
            log.error("task with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found task with this id: " + id);
        }));
    }

    @Override
    public void deleteById(Long id) {
        if (!taskRepository.existsById(id)) {
            log.error("task with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found task with id: " + id);
        }
        log.info("Delete task with id = {} ", id);
        taskRepository.deleteById(id);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest, Long lessonId) {
        if (!lessonRepository.existsById(lessonId)) {
            log.error("lesson with id = {} does not exists in database", lessonId);
            throw new ResourceNotFoundException("Not found lesson with this id: " + lessonId);
        }
        Task task = taskRepository.findById(id).orElseThrow(() -> {
            log.error("task with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found task with this id: " + id);
        });
        taskMapper.update(task, taskRequest);
        log.info("Update task with this id = {} ", id);
        return taskMapper.taskToTaskResponse(taskRepository.save(task));
    }
}
