package kg.peaksoftlms.peaksoftlms.db.dto.lesson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LessonResponse {
    private Long id;
    private String lessonName;
    private String link;
}
