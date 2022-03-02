//package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import kg.peaksoftlms.peaksoftlms.db.enums.EQuestionType;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//import static javax.persistence.CascadeType.*;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class QuestionResult {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String question;
//    @Enumerated(EnumType.STRING)
//    private EQuestionType eQuestionType;
//
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {MERGE, REFRESH, PERSIST})
//    private Question question;
//    @OneToMany
//    private List<Option> optionList;
//    @ManyToOne
//    @JoinColumn(name = "test_id")
//    private Test test;
//}
