//package kg.peaksoftlms.peaksoftlms.db.mapperGroupCrud;
//
//import kg.peaksoftlms.peaksoftlms.db.model.Group;
//import kg.peaksoftlms.peaksoftlms.db.model.Student;
//import kg.peaksoftlms.peaksoftlms.db.repository.StudentRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Component
//@AllArgsConstructor
//public class GroupUpdateMapper {
//    private final StudentRepository studentRepository;
//
//    public Group groupToNewGroup(Group group) {
//        if (group == null) {
//            return null;
//        }
//        Group newGroup = new Group();
//        newGroup.setId(group.getId());
//        newGroup.setName(group.getName());
//        newGroup.setDescription(group.getDescription());
//        newGroup.setDateOfCreate(group.getDateOfCreate());
//        List<Student> studentList = new ArrayList<>();
////        for (Student t : group.get) {
////            studentList.add(studentRepository.getById(t.getId()));
////        }
////        newGroup.setStudent(studentList);
//        return newGroup;
//    }
//}
