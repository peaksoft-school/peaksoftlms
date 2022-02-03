package kg.peaksoftlms.peaksoftlms.db.mapperGroupCrud;

import kg.peaksoftlms.peaksoftlms.db.dto.GroupRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Group;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public Group groupRequestToGroup(GroupRequest groupRequest) {
        if (groupRequest == null) {
            return null;
        }
        return modelMapper.map(groupRequest, Group.class);
    }


    public GroupResponse groupToGroupResponse(Group group) {
        if (group == null) {
            return null;
        }
        return modelMapper.map(group, GroupResponse.class);
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
