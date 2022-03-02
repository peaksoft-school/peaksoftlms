//package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;
//
//import kg.peaksoftlms.peaksoftlms.db.model.Student;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class TestingResult {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(columnDefinition = "text")
//    private String chosenAnswer;
//
//    private long optionId;
//
//    private double grade;
//
//    @OneToMany
//    private List<Answer> answers;
//
//    @ManyToOne
//    private Student student;
//
//    @ManyToOne
//    private Test test;
//}
