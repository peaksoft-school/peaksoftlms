package kg.peaksoftlms.peaksoftlms.db.repository.lesson;

import kg.peaksoftlms.peaksoftlms.db.model.lesson.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByLessonId(Long lessonId);
}
