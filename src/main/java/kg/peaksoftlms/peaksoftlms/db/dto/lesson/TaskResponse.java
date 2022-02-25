package kg.peaksoftlms.peaksoftlms.db.dto.lesson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private Long id;
    private String taskName;
    private String task;
    private String img;
}
