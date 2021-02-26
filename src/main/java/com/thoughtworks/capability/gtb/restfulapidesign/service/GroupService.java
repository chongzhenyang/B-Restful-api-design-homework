package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;

import java.util.Optional;

public interface GroupService {
    Group updateGroupName(Long id, String newName);

    String getGroupInfo();

    Optional<Group> findGroupById(Long id);

    Group createGroup(Group group);
}
