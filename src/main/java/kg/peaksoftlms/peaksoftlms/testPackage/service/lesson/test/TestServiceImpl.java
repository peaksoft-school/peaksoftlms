package kg.peaksoftlms.peaksoftlms.testPackage.service.lesson.test;

import kg.peaksoftlms.peaksoftlms.testPackage.dto.lesson.test.TestRequest;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Lesson;
import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.test.Test;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.LessonRepository;
import kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson.TestRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TestServiceImpl implements TestService {
    private final LessonRepository lessonRepository;
    private final TestRepository testRepository;

    @Override
    public Test saveTest(TestRequest testRequest, Long lessonId) {
        Test test = new Test();
        test.setLesson(getLesson(lessonId));
        test.setTitle(testRequest.getTitle());
        test.setActive(testRequest.isActive());
        return testRepository.save(test);
    }

    @Override
    public List<Test> getAllByLessonId(Long lessonId) {
        getLesson(lessonId);
        return testRepository.findByLessonId(lessonId);
    }

    @Override
    public Test getById(Long id) {
        return testRepository.findById(id).orElseThrow(() -> {
            log.error("test with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found test with this id: " + id);
        });
    }

    @Override
    public void deleteById(Long id) {
        if (!testRepository.existsById(id)) {
            log.error("test with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found test with id: " + id);
        }
        log.info("Delete test with id = {} ", id);
        testRepository.deleteById(id);
    }

    @Override
    public Test updateTest(Long id, TestRequest testRequest, Long lessonId) {
        if (!lessonRepository.existsById(lessonId)) {
            log.error("lesson with id = {} does not exists in database", lessonId);
            throw new ResourceNotFoundException("Not found lesson with this id: " + lessonId);
        }
        Test test = testRepository.findById(id).orElseThrow(() -> {
            log.error("test with id = {} does not exists in database", id);
            throw new ResourceNotFoundException("Not found test with this id: " + id);
        });
        test.setTitle(testRequest.getTitle());
        return testRepository.save(test);
    }

    private Lesson getLesson(Long lessonId) {
        return lessonRepository.findById(lessonId).orElseThrow(() -> {
            log.error("lesson with id = {} does not exists in database", lessonId);
            throw new ResourceNotFoundException("Not found lesson with this id: " + lessonId);
        });
    }
}
