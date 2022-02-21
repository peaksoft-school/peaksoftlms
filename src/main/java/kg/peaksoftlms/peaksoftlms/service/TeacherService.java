package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;

public interface TeacherService {

    List<TeacherResponse> findAll();

    TeacherResponse findById(Long id);

    TeacherResponse save(TeacherRequest teacherRequest);

    TeacherResponse update(TeacherRequest teacherRequest, Long id);

    void delete(Long id);
}
