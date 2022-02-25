package kg.peaksoftlms.peaksoftlms.api.lessonApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.LessonRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.LessonResponse;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import kg.peaksoftlms.peaksoftlms.service.lesson.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/instructor/lessons")
@Tag(name = "Контроллер для управления уроками",
        description = "Позволяет получить, удалить, добaвить или обновить всех уроков")
public class LessonApi {
    private final LessonService lessonService;

    @GetMapping("")
    @Operation(summary = "Для получения всех уроков", description = "Позволяет получить все курсы")
    public ResponseEntity<List<LessonResponse>> getAllLessons() {
        return new ResponseEntity<>(lessonService.getAllLessons(), HttpStatus.OK);
    }


    @GetMapping("/name/{lessonName}")
    @Operation(summary = "Для получения всех уроков по названию урока",
            description = "Позволяет получить все уроки по названию урока, " +
                    "если начало имени урока совпадает, то выведет все уроки")
    public ResponseEntity<List<LessonResponse>> getAllLessonsByName(@PathVariable("lessonName")
                                                                            String lessonName) {
        List<LessonResponse> lessonList = lessonService.getByLessonName(lessonName);
        if (lessonList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lessonList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Для получения урока по ID",
            description = "Позволяет получить урок по ID")
    public ResponseEntity<LessonResponse> getLessonById(@PathVariable("id") Long id) {
        LessonResponse lessonResponse = lessonService.getLessonById(id);
        if (lessonResponse == null) {
            throw new ResourceNotFoundException("Not found lesson with id: " + id);
        }
        return new ResponseEntity<>(lessonResponse, HttpStatus.OK);
    }

    @PostMapping("")
    @Operation(summary = "Для добавления уроков", description = "Позволяет добавить урок")
    public ResponseEntity<LessonResponse> saveNewLesson(@RequestBody LessonRequest lessonRequest) {
        LessonResponse lesson = lessonService.saveLesson(lessonRequest);
        return new ResponseEntity<>(lesson, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Для обновления урока", description = "Позволяет обновить урок по ID")
    public ResponseEntity<LessonResponse> updateLesson(@PathVariable("id") Long id,
                                                       @RequestBody LessonRequest lessonRequest) {
        return new ResponseEntity<>(lessonService.updateLesson(lessonRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Для удаления уроков", description = "Позволяет удалить урок")
    public ResponseEntity<LessonResponse> deleteLesson(@PathVariable("id") Long id) {
        lessonService.deleteLesson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping("/{id}/link")
//    @Operation(summary = "Для добавления link", description = "Позволяет добавить link")
//    public ResponseEntity<?> saveNewLesson(@PathVariable Long id,
//                                                @RequestBody String link) {
//        lessonService.addLink(id, link);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
