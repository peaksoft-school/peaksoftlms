package kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson;

import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByLessonId(Long lessonId);

    void deleteByLesson_Id(Long lessonId);
}
