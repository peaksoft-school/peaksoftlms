package kg.peaksoftlms.peaksoftlms.mapperGroupCrud;

import kg.peaksoftlms.peaksoftlms.db.dto.GroupRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Group;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.repository.StudentRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@AllArgsConstructor
public class GroupUpdateMapper {
    private final StudentRepository studentRepository;

    public Group groupToNewGroup(Group group) {
        if (group == null) {
            return null;
        }
        Group newGroup = new Group();
        newGroup.setId(group.getId());
        newGroup.setName(group.getName());
        newGroup.setDescription(group.getDescription());
        newGroup.setImg(group.getImg());
        newGroup.setDateOfCreate(group.getDateOfCreate());
        List<Student> studentList = new ArrayList<>();
        for (Student t : group.getStudent()) {
            studentList.add(studentRepository.getById(t.getId()));
        }
        newGroup.setStudent(studentList);
        return newGroup;
    }
}
