package kg.peaksoftlms.peaksoftlms.service.lesson;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.LessonRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.LessonResponse;

import java.util.List;

public interface LessonService {

    List<LessonResponse> getAllLessons();

    LessonResponse saveLesson(LessonRequest lessonRequest);

    LessonResponse getLessonById(Long id);

    List<LessonResponse> getByLessonName(String lessonName);

    void deleteLesson(Long id);

    void addLink(Long id, String link);

    LessonResponse updateLesson(LessonRequest lessonRequest, Long id);
}
