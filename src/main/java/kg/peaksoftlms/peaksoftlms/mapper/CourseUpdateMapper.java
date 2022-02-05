package kg.peaksoftlms.peaksoftlms.mapper;

import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CourseUpdateMapper {

    private final TeacherRepository teacherRepository;

    public Course courseToNewCourse(Course course) {
        if (course == null) {
            return null;
        }
        Course newCourse = new Course();
        newCourse.setId(course.getId());
        newCourse.setName(course.getName());
        newCourse.setDescription(course.getDescription());
        newCourse.setImg(course.getImg());
        newCourse.setDateOfCreate(course.getDateOfCreate());
        List<Teacher> teacherList = new ArrayList<>();
        for (Teacher t : course.getTeacher()) {
            teacherList.add(teacherRepository.getById(t.getId()));
        }
        newCourse.setTeacher(teacherList);
        return newCourse;
    }
}
