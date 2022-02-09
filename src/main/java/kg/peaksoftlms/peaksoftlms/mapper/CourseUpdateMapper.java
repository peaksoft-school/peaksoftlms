package kg.peaksoftlms.peaksoftlms.mapper;

import kg.peaksoftlms.peaksoftlms.db.dto.CourseRequest;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseUpdateMapper {
    public void update(Course course, CourseRequest request) {
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setImg(request.getImg());
    }
}
