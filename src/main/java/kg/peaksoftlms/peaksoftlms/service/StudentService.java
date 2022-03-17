package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.StudentResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Student;

import java.util.List;

public interface StudentService {

    List<StudentResponse> findAll(int page, int size);

    StudentResponse findById(Long id);

    StudentResponse saveNew(StudentRequest student);
    Student save(Student student);

    StudentResponse update(Long id, StudentRequest studentRequest);

    void delete(Long id);
}
