package kg.peaksoftlms.peaksoftlms.db.dto;

import kg.peaksoftlms.peaksoftlms.db.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDTO {

    private String name;
    private String lastName;
    private String description;
    private String img;
    private LocalDate dateOfCreate;
    private List<Teacher> teacher;
}
