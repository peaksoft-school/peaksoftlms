package kg.peaksoftlms.peaksoftlms.db.model.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Table
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Video {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String videoName;
    private String video;
   @ManyToOne
    private Lesson lesson;
}
