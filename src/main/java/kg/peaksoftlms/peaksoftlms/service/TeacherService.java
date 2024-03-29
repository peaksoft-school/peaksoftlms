package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<TeacherResponse> findAll();

    TeacherResponse findById(Long id);

    TeacherResponse save(TeacherRequest teacherRequest);

    TeacherResponse update(TeacherRequest teacherRequest, Long id);

    void delete(Long id);
}
