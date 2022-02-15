package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseRequest {

    private String name;
    private String description;
    private String img;
//    private LocalDate dateOfCreate;
//    private List<TeacherObject> teacher;
}
