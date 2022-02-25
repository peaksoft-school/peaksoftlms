//package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;
//
//import kg.peaksoftlms.peaksoftlms.db.enums.EQuestionType;
//import kg.peaksoftlms.peaksoftlms.db.model.lesson.Test;
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
//public class Question {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String title;
//    private String question;
//    @Enumerated(EnumType.STRING)
//    private EQuestionType eQuestionType;
//    @OneToMany
//    private List<Option> optionList;
//
//    @ManyToOne
//    private Test test;
//}
