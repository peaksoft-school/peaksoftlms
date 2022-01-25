package kg.peaksoftlms.peaksoftlms.db.dto;

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
public class CourseRequestDTO {

    private String name;
    private String lastName;
    private String description;
    private String img;
    private LocalDate dateOfCreate;
    private List<TeacherRequestDTO> teacher;
}
