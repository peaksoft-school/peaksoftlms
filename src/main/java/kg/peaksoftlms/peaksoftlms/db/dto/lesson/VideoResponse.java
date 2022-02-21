package kg.peaksoftlms.peaksoftlms.db.dto.lesson;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VideoResponse {
    private Long id;
    private String name;
    private String video;
    private String description;
}
