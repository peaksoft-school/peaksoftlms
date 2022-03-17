package kg.peaksoftlms.peaksoftlms.aaTest.repository.lesson;

import kg.peaksoftlms.peaksoftlms.aaTest.model.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Optional<List<Lesson>> findByNameContaining(String name);
}
