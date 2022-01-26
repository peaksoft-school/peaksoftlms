package kg.peaksoftlms.peaksoftlms.mapper;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.CourseResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CourseMapper {
    private final ModelMapper modelMapper;

    public Course courseRequestToCourse(CourseRequest courseRequest) {
        if (courseRequest == null) {
            return null;
        }
        return modelMapper.map(courseRequest, Course.class);
    }


    public CourseResponse courseToCourseResponse(Course course) {
        if (course == null) {
            return null;
        }
        return modelMapper.map(course, CourseResponse.class);
    }

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
}
