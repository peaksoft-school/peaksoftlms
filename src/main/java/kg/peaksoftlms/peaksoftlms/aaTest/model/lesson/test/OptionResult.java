//package kg.peaksoftlms.peaksoftlms.db.model.lesson.test;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//
//import static javax.persistence.CascadeType.*;
//
//public class OptionResult {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private boolean answer;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {MERGE, REFRESH, PERSIST})
//    @JsonIgnore
//    private Option option;
//
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {MERGE, REFRESH, PERSIST})
//    @JsonIgnore
//    private QuestionResult questionResult;
//}
