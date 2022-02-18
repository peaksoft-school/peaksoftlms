package kg.peaksoftlms.peaksoftlms.service.courseService;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.dto.TeacherIdForCourseRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import kg.peaksoftlms.peaksoftlms.db.repository.CourseRepository;
import kg.peaksoftlms.peaksoftlms.db.repository.TeacherRepository;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import kg.peaksoftlms.peaksoftlms.mapper.CourseMapper;
import kg.peaksoftlms.peaksoftlms.mapper.CourseUpdateMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseUpdateMapper courseUpdateMapper;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseMapper.courseListToCourseResponseList(courseRepository.findAll());
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        log.info("Get course by id: {}", id);
        return courseMapper.courseToCourseResponse(courseRepository.findById(id).orElseThrow(() -> {
            log.info("course with id = {} does not exists in database", id);
            throw new NotFoundException("course with id = " + id + " does not exists in database");
        }));
    }

    @Override
    public CourseResponse getCourseByName(String name) {
        log.info("get course by name: {}", name);
        if (name == null) {
            return null;
        }
        return courseMapper.courseToCourseResponse(courseRepository.findByName(name).orElseThrow(() -> {
            log.info("course with name = {} does not exists in database", name);
            throw new ResourceNotFoundException("course with id = " + name + " does not exists in database");
        }));
    }

    @Override
    public CourseResponse saveCourse(CourseRequest courseRequest) {
        return courseMapper.courseToCourseResponse(courseRepository
                .save(courseMapper.courseRequestToCourse(courseRequest)));
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.getById(id);
        courseUpdateMapper.update(course, courseRequest);
        CourseResponse courseResponse =
                courseMapper.courseToCourseResponse(courseRepository.save(course));
        log.info("updated course: {}", course.getName());
        return courseResponse;
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Not found course with id: " + id);
        }
        log.info("Delete course by id: {}", id);
        courseRepository.deleteById(id);
    }

    @Override
    public CourseResponse addTeacherToCourse(Long courseId, TeacherIdForCourseRequest teacherIdList) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> {
            log.info("course with id = {} does not exists in database", courseId);
            throw new NotFoundException("course with id = " + courseId + " does not exists in database");
        });
        course.setTeacher(getTeacherToCourse(teacherIdList));
        log.info("Adding teacher {} to Course {}", teacherIdList, courseId);
        return courseMapper.courseToCourseResponse(courseRepository.save(course));
    }

    public List<Teacher> getTeacherToCourse(TeacherIdForCourseRequest teacher) {
        List<Teacher> teacherList = new ArrayList<>();
        for (Long aLong : teacher.getLongListId()) {
            teacherList.add(teacherRepository.findById(aLong)
                    .orElseThrow(() -> {
                        log.info("teacher with id = {} does not exists in database", aLong);
                        throw new NotFoundException(
                                "teacher with id = " + aLong + " does not exists in database");
                    }));
        }
        return teacherList;
    }
}
