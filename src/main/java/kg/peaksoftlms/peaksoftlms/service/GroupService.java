package kg.peaksoftlms.peaksoftlms.service;

import kg.peaksoftlms.peaksoftlms.db.dto.GroupRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;

public interface GroupService {
    GroupResponse addNewGroup(GroupRequest groupRequest);

    GroupResponse getAllGroups(GroupRequest groupRequest);

}
