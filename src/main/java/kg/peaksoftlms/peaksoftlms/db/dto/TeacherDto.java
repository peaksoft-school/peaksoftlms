package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter@Setter
public class TeacherDto {
    private Long id;
    private String name;
    private Long userId;
}
