package kg.peaksoftlms.peaksoftlms.mapper;

import kg.peaksoftlms.peaksoftlms.db.dto.StudentRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.StudentResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class StudentMapper {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public StudentResponse studentToStudentResponse(Student student) {
        return modelMapper.map(student, StudentResponse.class);
    }

    public List<StudentResponse> studentListToStudentResponseList(List<Student> studentList) {
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student : studentList) {
            studentResponseList.add(studentToStudentResponse(student));
        }
        return studentResponseList;
    }

    public Student studentRequestToStudent(Student student, StudentRequest request) {
        student.setEmail(request.getEmail());
        student.setLastName(request.getLastName());
        student.setFirstName(request.getFirstName());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setPassword(passwordEncoder.encode(request.getPassword()));
        student.setLearningFormat(request.getLearningFormat());
        return student;
    }

    public Student updateStudent(Student student, StudentRequest request) {
        student.setEmail(request.getEmail());
        student.setLastName(request.getLastName());
        student.setFirstName(request.getFirstName());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setLearningFormat(request.getLearningFormat());
        return student;
    }
}
