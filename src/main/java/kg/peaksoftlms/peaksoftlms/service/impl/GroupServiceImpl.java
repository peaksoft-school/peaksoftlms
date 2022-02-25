package kg.peaksoftlms.peaksoftlms.service.impl;

import kg.peaksoftlms.peaksoftlms.db.dto.GroupRequest;
import kg.peaksoftlms.peaksoftlms.db.dto.GroupResponse;
import kg.peaksoftlms.peaksoftlms.db.model.Group;
import kg.peaksoftlms.peaksoftlms.db.model.Student;
import kg.peaksoftlms.peaksoftlms.db.model.User;
import kg.peaksoftlms.peaksoftlms.db.repository.GroupRepository;
import kg.peaksoftlms.peaksoftlms.exceptions.AlreadyExistsException;
import kg.peaksoftlms.peaksoftlms.exeption.ResourceNotFoundException;
import kg.peaksoftlms.peaksoftlms.mapper.GroupMapper;
import kg.peaksoftlms.peaksoftlms.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;
    private final GroupMapper groupMapper;


    @Override
    public GroupResponse addNewGroup(GroupRequest groupRequest) {
        //change groupRequest to group class GroupRequest.class => Group.class
        Group group = modelMapper.map(groupRequest, Group.class);
        //check is there same group
        if (groupRepository.existsByName(groupRequest.getName())) {
            log.error("group with name {} has already exists", group.getName());
            throw new AlreadyExistsException(
                    "group with name = " + group.getName() + " has already exists"
            );
        }

        //is not exists then save to database
        Group save = groupRepository.save(group);

        log.info("succesfully added group with name = {}", save.getName());
        return new GroupResponse(save.getName(), "group " + save.getName() + " successfully created");
    }

    @Override
    public List<GroupResponse> getAllGroups() {
        List<Group> groupList = groupRepository.findAll();
        return groupMapper.groupListToGroupResponseList(groupList);
    }

    @Override
    public Group getById(Long id) {
        return groupRepository.findById(id).get();
    }

//    @Override
//    public GroupResponse updateById(GroupRequest groupRequest) {
//        return groupMapper.groupToGroupResponse(groupRepository
//                .save(groupMapper.groupRequestToGroup(groupRequest)));
//    }

    @Override
    public GroupResponse deleteById(Long id) {
        Group group = groupRepository.findById(id).get();
//        {log.info("Not found group with id: {}", id);
//            throw new ResourceNotFoundException("Not found group with id: " + id);
//        }
        groupRepository.deleteById(id);
        return groupMapper.groupToGroupResponse(group);
    }

    @Override
    public GroupResponse saveGroup(GroupRequest groupRequest) {
        return groupMapper.groupToGroupResponse(groupRepository.save(groupMapper.groupRequestToGroup(groupRequest)));
    }
}
