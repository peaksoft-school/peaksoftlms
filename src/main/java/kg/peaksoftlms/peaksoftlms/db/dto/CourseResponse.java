package kg.peaksoftlms.peaksoftlms.db.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CourseResponse {

    private Long id;
    private String name;
    private String description;
    private String img;
    private LocalDate createdAt;

    //private List<Teacher> teacher;

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt.toLocalDate();
    }
}
