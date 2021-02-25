package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Group;

public interface GroupService {
    Group updateGroupName(Long id, String newName);
    String getGroupInfo();
}
