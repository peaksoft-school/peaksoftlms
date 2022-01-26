package kg.peaksoftlms.peaksoftlms.mapper;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MapStructMapperForCourseImpl implements MapStructMapperForCourse {
    private final TeacherRepository teacherRepository;

    @Override
    public TeacherRequest teacherToTeacherRequest(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        TeacherRequest teacherRequest = new TeacherRequest();
        teacherRequest.setId(teacher.getId());
        teacherRequest.setTeacherName(teacher.getTeacherName());
        teacherRequest.setTeacherLastName(teacher.getTeacherLastName());
        return teacherRequest;
    }

    @Override
    public Teacher teacherRequestToTeacher(TeacherRequest teacherRequest) {
        if (teacherRequest == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setId(teacherRequest.getId());
        teacher.setTeacherName(teacherRequest.getTeacherName());
        teacher.setTeacherLastName(teacherRequest.getTeacherLastName());
        return teacher;
    }

    @Override
    public Course courseRequestToCourse(CourseRequest courseRequest) {
        if (courseRequest == null) {
            return null;
        }
        Course course = new Course();
        //course.setId(courseRequest.getId());
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setImg(courseRequest.getImg());
        course.setDateOfCreate(courseRequest.getDateOfCreate());
        course.setTeacher(teacherRequestListToTeacherList(courseRequest.getTeacher()));
        return course;
    }

    @Override
    public CourseRequest courseToCourseRequest(Course course) {
        if (course == null) {
            return null;
        }
        CourseRequest courseRequest = new CourseRequest();
        //courseRequest.setId(course.getId());
        courseRequest.setName(course.getName());
        courseRequest.setDescription(course.getDescription());
        courseRequest.setImg(course.getImg());
        courseRequest.setDateOfCreate(course.getDateOfCreate());
        courseRequest.setTeacher(teacherListToTeacherRequestList(course.getTeacher()));
        return courseRequest;
    }

    @Override
    public Course courseResponseToCourse(CourseResponse courseResponse) {
        if (courseResponse == null) {
            return null;
        }
        Course course = new Course();
        //course.setId(courseResponse.getId());
        course.setName(courseResponse.getName());
        course.setDescription(courseResponse.getDescription());
        course.setImg(courseResponse.getImg());
        course.setDateOfCreate(courseResponse.getDateOfCreate());
        course.setTeacher(teacherRequestListToTeacherList(courseResponse.getTeacher()));
        return course;
    }

    @Override
    public CourseResponse courseToCourseResponse(Course course) {
        if (course == null) {
            return null;
        }
        CourseResponse courseResponse = new CourseResponse();
        //courseResponse.setId(course.getId());
        courseResponse.setName(course.getName());
        courseResponse.setDescription(course.getDescription());
        courseResponse.setImg(course.getImg());
        courseResponse.setDateOfCreate(course.getDateOfCreate());
        courseResponse.setTeacher(teacherListToTeacherRequestList(course.getTeacher()));
        return courseResponse;
    }

    @Override
    public List<CourseResponse> courseListToCourseResponseList(List<Course> courseList) {
        if (courseList == null) {
            return null;
        }
        List<CourseResponse> courseResponseList = new ArrayList<>();
        for (Course course : courseList) {
            courseResponseList.add(courseToCourseResponse(course));
        }
        return courseResponseList;
    }

    protected List<TeacherRequest> teacherListToTeacherRequestList(List<Teacher> teacherList) {
        if (teacherList == null) {
            return null;
        }
        List<TeacherRequest> teacherRequestList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            teacherRequestList.add(teacherToTeacherRequest(teacher));
        }
        return teacherRequestList;
    }

    protected List<Teacher> teacherRequestListToTeacherList(List<TeacherRequest> teacherRequestList) {
        if (teacherRequestList == null) {
            return null;
        }
        List<Teacher> teacherList = new ArrayList<>();
        for (TeacherRequest teacher : teacherRequestList) {
            teacherList.add(teacherRequestToTeacher(teacher));
        }
        return teacherList;
    }
}
