package kg.peaksoftlms.peaksoftlms.testPackage.repository.lesson;

import kg.peaksoftlms.peaksoftlms.testPackage.model.lesson.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    List<Presentation> findByLessonId(Long lessonId);

    void deleteByLesson_Id(Long lessonId);
}
