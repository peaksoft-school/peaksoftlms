package kg.peaksoftlms.peaksoftlms.db.repository;

import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByUser(User user);

}
