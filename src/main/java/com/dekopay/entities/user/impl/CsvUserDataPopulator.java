package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.User;
import com.dekopay.entities.user.UserDataPopulator;
import com.dekopay.services.impl.CsvDatasetHandler;

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
        CsvDatasetHandler csvDatasetHandler = new CsvDatasetHandler();
        Integer userId = Integer.parseInt(data.get(USER_ID).toString());
        user.setUserId(userId);
        user.setFirstName(data.get(FIRST_NAME).toString());
        user.setLastName(data.get(LAST_NAME).toString());
        user.setUsername(data.get(USERNAME).toString());
        user.setUserType(data.get(USER_TYPE).toString());
        user.setLastLoginTime(csvDatasetHandler.converDateToIsoDate(data.get(LAST_LOGIN_TIME).toString()));
        return user;
    }

    @Override
    public List<List<String>> mapUser(Collection<User> collection) {
        List list = new ArrayList();
        //add the csv header
        list.add(Arrays.asList(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, LAST_LOGIN_TIME));
        //add all the users (Id needs to convert to string)
        for (User user : collection) {
            list.add(Arrays.asList(user.getUserId().toString(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getUserType(), user.getLastLoginTime()));
        }
        List<List<String>> dataLines = list;
        return dataLines;
    }
}


