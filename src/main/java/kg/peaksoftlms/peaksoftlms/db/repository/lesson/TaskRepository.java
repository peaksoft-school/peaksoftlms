package kg.peaksoftlms.peaksoftlms.db.repository.lesson;

import kg.peaksoftlms.peaksoftlms.db.model.lesson.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByLessonId(Long lessonId);
}
