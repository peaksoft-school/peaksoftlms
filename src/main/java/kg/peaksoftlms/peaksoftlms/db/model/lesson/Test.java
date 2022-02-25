//package kg.peaksoftlms.peaksoftlms.db.model.lesson;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import kg.peaksoftlms.peaksoftlms.db.model.lesson.test.Question;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//import org.springframework.data.annotation.CreatedDate;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Entity
//@Table
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Test {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String title;
//    private String description;
//    private int testCodeQuantity;
//
//    @CreatedDate
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    private LocalDateTime startTime;
//    private LocalDateTime endTime;
//
//    @Column(name = "doing_duration")
//    private int duration; // stored by minutes
//
//    //private int status; // 1: active, 0: inactive
//
//    @OneToMany
//    private List<Question> question;
//
//
//    //    @OneToMany(fetch =LAZY, cascade = {DETACH, MERGE, PERSIST, REFRESH})
//    @ManyToOne
//    @JsonIgnore
//    private Lesson lesson;
//}
