package kg.peaksoftlms.peaksoftlms.api.lessonApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.VideoRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.VideoResponse;
import kg.peaksoftlms.peaksoftlms.service.lesson.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/instructor/lessons")
@Tag(name = "Контроллер для видео", description = "Позволяет получить, добавить, обновить и удалить видео")
public class VideoApi {
    private final VideoService videoService;

    @GetMapping("/{lessonId}/video")
    @Operation(summary = "Для получения всех видео",
            description = "Позволяет получить все видео по LESSON ID")
    public ResponseEntity<List<VideoResponse>> getAllVideoByLessonId(@PathVariable("lessonId") Long lessonId) {
        return new ResponseEntity<>(videoService.getAllVideoByLessonId(lessonId), HttpStatus.OK);
    }

    @GetMapping("/video/{id}")
    @Operation(summary = "Для получения видео",
            description = "Позволяет получить видео по ID")
    public ResponseEntity<VideoResponse> getVideoById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(videoService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/{lessonId}/videos")
    @Operation(summary = "Для создания нового видео",
            description = "Позволяет создать новое видео")
    public ResponseEntity<VideoResponse> saveNewVideo(@PathVariable("lessonId") Long lessonId,
                                                      @RequestBody VideoRequest videoRequest) {
        return new ResponseEntity<>(videoService.saveNew(videoRequest, lessonId), HttpStatus.CREATED);
    }

    @PutMapping("/{lessonId}/video/{id}")
    @Operation(summary = "Для обновления видео",
            description = "Позволяет обновить видео по ID")
    public ResponseEntity<VideoResponse> updateVideo(@PathVariable("lessonId") Long lessonId,
                                                     @PathVariable("id") Long id,
                                                     @RequestBody VideoRequest videoRequest) {
        return new ResponseEntity<>(videoService.update(lessonId, id, videoRequest), HttpStatus.OK);
    }

    @DeleteMapping("/video/{id}")
    @Operation(summary = "Для удаления видео",
            description = "Позволяет удалить видео по ID")
    public ResponseEntity<VideoResponse> deleteVideo(@PathVariable("id") Long id) {
        videoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
