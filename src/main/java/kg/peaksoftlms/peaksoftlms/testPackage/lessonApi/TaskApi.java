package kg.peaksoftlms.peaksoftlms.testPackage.lessonApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.TaskRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.TaskResponse;
import kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/instructor/lessons")
@Tag(name = "Контроллер для управления заданиями",
        description = "Позволяет получить, удалить, добавить или обновить всех заданий")
public class TaskApi {
    private final TaskService taskService;

    @GetMapping("/{lessonId}/tasks")
    @Operation(summary = "Для получения всех заданий",
            description = "Позволяет получить все задания по LESSON ID")
    public ResponseEntity<List<TaskResponse>> getAllTasksByLessonId(@PathVariable("lessonId") Long lessonId) {
        return new ResponseEntity<>(taskService.getAllByLessonId(lessonId), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    @Operation(summary = "Для получения задания по ID", description = "Позволяет получить задание по ID")
    public ResponseEntity<TaskResponse> getTask(@PathVariable("id") Long id) {
        return new ResponseEntity<>(taskService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/{lessonId}/tasks")
    @Operation(summary = "Для создания нового задания", description = "Позволяет создать новое задание")
    public ResponseEntity<TaskResponse> saveNewTask(@PathVariable("lessonId") Long lessonId,
                                                    @RequestBody TaskRequest taskRequest) {
        return new ResponseEntity<>(taskService.saveTask(taskRequest, lessonId), HttpStatus.CREATED);
    }

    @PutMapping("/{lessonId}/tasks/{id}")
    @Operation(summary = "Для обновления задания",
            description = "Позволяет обновить задание по ID и LESSON ID")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable("lessonId") Long lessonId,
                                                   @PathVariable("id") Long id,
                                                   @RequestBody TaskRequest taskRequest) {
        return new ResponseEntity<>(taskService.updateTask(id, taskRequest, lessonId),
                HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    @Operation(summary = "Для удаления задания", description = "Позволяет удалить задание по ID")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
