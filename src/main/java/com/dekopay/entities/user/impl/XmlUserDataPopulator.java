package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.User;
import com.dekopay.entities.user.UserDataPopulator;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class XmlUserDataPopulator extends UserDataPopulator {

    @Override
    public User populate(User user, Map data) {
        user.setUserId((String) data.get("userid"));
        user.setFirstName((String) data.get("firstname"));
        user.setLastName((String) data.get("surname"));
        user.setUsername((String) data.get("username"));
        user.setUserType((String) data.get("type"));
        user.setLastLoginTime((String) data.get("lastlogintime"));
        return user;
    }

    @Override
    public List<List<String>> mapUser(Collection<User> collection) {
        return null;
    }
}
