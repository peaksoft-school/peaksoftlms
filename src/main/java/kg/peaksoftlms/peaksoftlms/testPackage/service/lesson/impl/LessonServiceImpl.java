package kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.impl;

import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.LessonRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.LessonResponse;
import kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.LessonService;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Lesson;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.LessonRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import kg.peaksoftlms.peaksoftlms.testPackage.mapper.lesson.LessonMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public List<LessonResponse> getAllLessons() {
        log.info("Get all lessons");
        return lessonMapper
                .lessonListToLessonResponseList(lessonRepository.findAll());
    }

    @Override
    public LessonResponse saveLesson(LessonRequest lessonRequest) {
        log.info("Save new lesson");
        return lessonMapper.lessonToLessonResponse(
                lessonRepository.save(lessonMapper.lessonRequestToLesson(lessonRequest)));
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        log.info("Get lesson with id = {}", id);
        return lessonMapper.lessonToLessonResponse(
                lessonRepository.findById(id).orElseThrow(() -> {
                    log.error("lesson with id = {} does not exists in database", id);
                    throw new ResourceNotFoundException("Not found lesson with id: " + id);
                }));
    }

    @Override
    public List<LessonResponse> getByLessonName(String lessonName) {
        log.info("get all lessons by lesson's name = {}", lessonName);
        return lessonMapper.lessonListToLessonResponseList(
                lessonRepository.findByNameContaining(lessonName).orElseThrow(() -> {
                    log.error("Not found lesson by name = {}", lessonName);
                    throw new ResourceNotFoundException("Not found lessons by lessons's name: " + lessonName);
                }));
    }

    @Override
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            log.error("lesson with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found lesson with id: " + id);
        }
        log.info("delete lesson by id = {}", id);
        lessonRepository.deleteById(id);
    }

    @Override
    public LessonResponse updateLesson(LessonRequest lessonRequest, Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> {
            log.error("lesson with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found lessons with id: " + id);
        });
        lessonMapper.update(lesson, lessonRequest);
        log.info("update lesson with id = {}", id);
        return lessonMapper.lessonToLessonResponse(lessonRepository.save(lesson));
    }

    @Override
    public void addLink(Long id, String link) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> {
            log.error("lesson with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found lessons with id: " + id);
        });
        lesson.setLink(link);
        lessonRepository.save(lesson);
    }
}
