package kg.peaksoftlms.peaksoftlms.api;

import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Course;
import kg.peaksoftlms.peaksoftlms.db.model.Group;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class GroupApi {


    @RestController
    @RequestMapping("/api/admin/groups")
    @AllArgsConstructor
    @Slf4j
    public class groupApi {

        private final GroupService groupService;
        private final GroupMapper groupMapper;

        @PostMapping("")
        public ResponseEntity<GroupResponse> addNewGroup(@Valid @RequestBody groupRequest groupRequest) {
            Group registeredNewGroup = groupService
                    .saveGroup(groupMapper.groupRequestToGroup(groupRequest));
            log.info("Save api group: {}", registeredNewGroup);
            return new ResponseEntity<>(groupMapper
                    .groupToCourseResponse(registeredNewGroup), HttpStatus.CREATED);
        }

        @GetMapping("")
        public ResponseEntity<List<GroupResponse>> getAllGroups() {
            List<Group> groupList = groupService.getAllGroups();
            List<GroupResponse> groupResponseList = groupMapper
                    .groupListToGroupResponseList(groupList);
            log.info("All groups: {}", groupResponseList);
            return new ResponseEntity<>(groupResponseList, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<GroupResponse> getGroupById(@PathVariable Long id) {
            return new ResponseEntity<>(groupMapper.groupToGroupResponse(
                    groupService.getGroupById(id)), HttpStatus.OK);
        }

        @GetMapping("/name/{name}")
        public ResponseEntity<GroupResponse> getGroupByName(@PathVariable String name) {
            Group group = groupService.getGroupByName(name);
            if (group == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(groupMapper
                    .groupToGroupResponse(group), HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Group> updateGroup(@RequestBody Group group, @PathVariable Long id) {
            groupService.updateGroup(id, group);
            return new ResponseEntity<>(group, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<GroupResponse> deleteGroup(@PathVariable Long id) {
            groupService.deleteGroup(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
