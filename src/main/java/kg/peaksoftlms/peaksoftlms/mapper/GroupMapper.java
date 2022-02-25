package kg.peaksoftlms.peaksoftlms.mapper;


import kg.peaksoftlms.peaksoftlms.db.dto.GroupRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Group;
import kg.peaksoftlms.peaksoftlms.db.repository.GroupRepository;
import kg.peaksoftlms.peaksoftlms.service.GroupService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupMapper {
    private final ModelMapper modelMapper;
    private final GroupRepository groupRepository;
    public GroupMapper(ModelMapper modelMapper, GroupRepository groupRepository) {
        this.modelMapper = modelMapper;
        this.groupRepository = groupRepository;
    }

    public GroupResponse groupToGroupResponse(Group group) {
        return modelMapper.map(group, GroupResponse.class);
    }

    public Group groupRequestToGroup (GroupRequest groupRequest){
        Group group = groupRepository.findById(groupRequest.getId()).get();
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
