//package kg.peaksoftlms.peaksoftlms.db.repository.lesson.test;
//
//import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.TestingResult;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface TestingResultRepository extends JpaRepository<TestingResult, Long> {
//    //int countTestingResultByTestAndStudentAndStatus(long testId, String email);
//
//   // Optional<TestingResult> findByTestAndStudent(long testId, String email);
//
//    Optional<TestingResult> findByTestAndStudent(Long testId, Long studentId);
//
//}
