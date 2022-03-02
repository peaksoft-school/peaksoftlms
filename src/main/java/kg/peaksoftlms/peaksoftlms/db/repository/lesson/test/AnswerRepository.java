//package kg.peaksoftlms.peaksoftlms.db.repository.lesson.test;
//
//import kg.peaksoftlms.peaksoftlms.db.model.Student;
//import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Answer;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface AnswerRepository extends JpaRepository<Answer, Long> {
//    Optional<Answer> findByTestingResultIdAndAndQuestionId(Long testResultId, Long questionId);
//
//    List<Answer> findByStudent(Student student);
//}
