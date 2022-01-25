package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequestDTO {
    private Long id;
    private String teacherName;
    private String teacherLastName;
}
