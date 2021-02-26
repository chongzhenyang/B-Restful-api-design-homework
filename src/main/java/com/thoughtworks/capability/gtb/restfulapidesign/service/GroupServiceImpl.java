package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    @Override
    public Group updateGroupName(Long id, String newName) {
        return null;
    }

    @Override
    public String getGroupInfo() {
        return null;
    }

    @Override
    public Optional<Group> findGroupById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }
}
