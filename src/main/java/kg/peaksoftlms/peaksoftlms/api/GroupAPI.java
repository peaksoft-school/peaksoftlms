package kg.peaksoftlms.peaksoftlms.api;

import io.swagger.v3.oas.annotations.Operation;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Group;
import kg.peaksoftlms.peaksoftlms.mapper.GroupMapper;
import kg.peaksoftlms.peaksoftlms.service.GroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/groups")
@AllArgsConstructor
@Slf4j
public class GroupAPI {

    private final GroupService groupService;
    private final GroupMapper groupMapper;

    @PostMapping("")
    @Operation(summary = "Для добавления груп", description = "Позволяет добавить группы")
    public GroupResponse addNewGroup(@Valid @RequestBody GroupRequest groupRequest) {
        return groupService.addNewGroup(groupRequest);
    }

    @GetMapping("")
    @Operation(summary = "Для получения всех группы", description = "Позволяет получить все группы")
    public List<GroupResponse> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Для получения группы по ID", description = "Позволяет получить групу по ID")
    public ResponseEntity<GroupResponse> getGroupById(@PathVariable Long id) {
        return new ResponseEntity<>(groupMapper.groupToGroupResponse(groupService.getById(id)), HttpStatus.OK);
    }
//
//        @GetMapping("/name/{name}")
//        public ResponseEntity<GroupResponse> getGroupByName(@PathVariable String name) {
//            Group group = groupService.getGroupByName(name);
//            if (group == null) {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(groupMapper
//                    .groupToGroupResponse(group), HttpStatus.OK);
//        }
//
        @PutMapping("/save/group")
        public ResponseEntity<Group> updateGroup(@RequestBody Group group) {
            return new ResponseEntity<>(groupService.saveGroup(group), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<GroupResponse> deleteGroup(@PathVariable Long id) {
            groupService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}


