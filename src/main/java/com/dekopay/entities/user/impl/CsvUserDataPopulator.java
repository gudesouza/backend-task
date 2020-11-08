package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.User;
import com.dekopay.entities.user.UserDataPopulator;

import java.util.*;

public class CsvUserDataPopulator extends UserDataPopulator {

    private static final String USER_ID = "User ID";
    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    private static final String USERNAME = "Username";
    private static final String USER_TYPE = "User Type";
    private static final String LAST_LOGIN_TIME = "Last Login Time";

    @Override
    public User populate(User user, Map data) {
        user.setUserId((String) data.get(USER_ID));
        user.setFirstName((String) data.get(FIRST_NAME));
        user.setLastName((String) data.get(LAST_NAME));
        user.setUsername((String) data.get(USERNAME));
        user.setUserType((String) data.get(USER_TYPE));
        user.setLastLoginTime((String) data.get(LAST_LOGIN_TIME));
        return user;
    }

    @Override
    public List<List<String>> mapUser(Collection<User> collection) {
        List list = new ArrayList();
        //add the csv header
        list.add(Arrays.asList(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, LAST_LOGIN_TIME));
        //add all the users
        for (User user : collection) {
            list.add(Arrays.asList(user.getUserId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getUserType(), user.getLastLoginTime()));
        }
        List<List<String>> dataLines = list;
        return dataLines;
    }
}


