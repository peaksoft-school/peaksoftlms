package kg.peaksoftlms.peaksoftlms.mapper;


import kg.peaksoftlms.peaksoftlms.db.dto.GroupRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Group;
import kg.peaksoftlms.peaksoftlms.service.GroupService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
//@AllArgsConstructor
public class GroupMapper {
    private final ModelMapper modelMapper;
    private GroupService groupService;

    public GroupMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GroupResponse groupToGroupResponse(Group group) {
        return modelMapper.map(group, GroupResponse.class);
    }

    public Group groupRequestToGroup (GroupRequest groupRequest){
        Group group = groupService.getById(groupRequest.getId());
        group.setId(groupRequest.getId());
        group.setName(groupRequest.getName());
        group.setDateOfCreate(groupRequest.getDateOfCreate());
        group.setDescription(groupRequest.getDescription());
        return group;
    }

    public List<GroupResponse> groupListToGroupResponseList(List<Group> groupList) {
        if (groupList == null) {
            return null;
        }
        List<GroupResponse> groupResponseList = new ArrayList<>();
        for (Group group : groupList) {
            groupResponseList.add(groupToGroupResponse(group));
        }
        return groupResponseList;
    }
}
