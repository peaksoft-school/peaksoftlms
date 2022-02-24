package kg.peaksoftlms.peaksoftlms.db.repository;

import kg.peaksoftlms.peaksoftlms.db.dto.StudentResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUser(User user);
    Page<Student> findAll(Pageable pageable);
}
