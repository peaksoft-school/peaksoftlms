package kg.peaksoftlms.peaksoftlms.db.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CourseResponse {

//    @JsonProperty("id")
//    private Long id;
    private String name;
    private String description;
    private String img;
    private LocalDate dateOfCreate;
    private List<TeacherRequest> teacher;
}
