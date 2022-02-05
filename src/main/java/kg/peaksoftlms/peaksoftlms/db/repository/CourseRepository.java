package kg.peaksoftlms.peaksoftlms.db.repository;

import kg.peaksoftlms.peaksoftlms.db.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String name);

}
