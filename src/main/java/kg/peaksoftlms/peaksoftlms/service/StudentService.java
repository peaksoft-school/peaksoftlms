package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    List<StudentResponse> findAll();

    StudentResponse findById(Long id);

    StudentResponse saveNew(StudentRequest student);

    StudentResponse update(Long id, StudentRequest studentRequest);

    void delete(Long id);
}
