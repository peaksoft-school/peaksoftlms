package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.model.User;

import java.util.List;

public interface TeacherService {

    TeacherResponse create(TeacherRequest teacherRequest);

    void delete(Long id);

//    TeacherResponse findByUser(User user);

    List<TeacherResponse> findAllByNameContaining(String name);

    TeacherResponse getByName(String name);

    List<TeacherResponse> getAllTeachers();

    TeacherResponse getTeacherById(Long id);

    TeacherResponse getByEmail(String email);

    TeacherResponse updateById (TeacherRequest teacherRequest, Long id);
}
