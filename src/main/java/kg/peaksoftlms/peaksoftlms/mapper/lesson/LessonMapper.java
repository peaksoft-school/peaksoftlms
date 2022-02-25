package kg.peaksoftlms.peaksoftlms.mapper.lesson;

import kg.peaksoftlms.peaksoftlms.db.dto.lesson.LessonRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.lesson.LessonResponse;
import kg.peaksoftlms.peaksoftlms.db.model.lesson.Lesson;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class LessonMapper {
    private final ModelMapper modelMapper;

    public Lesson lessonRequestToLesson(LessonRequest lessonRequest) {
        if (lessonRequest == null) {
            return null;
        }
        return modelMapper.map(lessonRequest, Lesson.class);
    }

    public LessonResponse lessonToLessonResponse(Lesson lesson) {
        if (lesson == null) {
            return null;
        }
        return modelMapper.map(lesson, LessonResponse.class);
    }

    public List<LessonResponse> lessonListToLessonResponseList(List<Lesson> lessonList) {
        if (lessonList == null) {
            return null;
        }
        List<LessonResponse> lessonResponseList = new ArrayList<>();
        for (Lesson lesson : lessonList) {
            lessonResponseList.add(lessonToLessonResponse(lesson));
        }
        return lessonResponseList;
    }

    public void update(Lesson lesson, LessonRequest lessonRequest) {
        lesson.setName(lessonRequest.getLessonName());
    }
}
