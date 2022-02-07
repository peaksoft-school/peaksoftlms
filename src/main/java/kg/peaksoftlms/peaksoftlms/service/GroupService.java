package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.GroupRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Group;

import java.util.List;

public interface GroupService {
    GroupResponse addNewGroup(GroupRequest groupRequest);

    List<GroupResponse> getAllGroups();

    Group getById(Long id);

    GroupResponse updateById(GroupRequest groupRequest);

    Group deleteById(Long id);

    Group saveGroup(Group group);
}
