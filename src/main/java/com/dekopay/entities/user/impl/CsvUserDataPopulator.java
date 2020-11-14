package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.User;
import com.dekopay.entities.user.DataPopulator;
import com.dekopay.services.datasetformation.impl.DefaultConverter;

import java.util.*;

public class CsvUserDataPopulator extends DataPopulator {

    private static final String USER_ID = "User ID";
    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    private static final String USERNAME = "Username";
    private static final String USER_TYPE = "User Type";
    private static final String LAST_LOGIN_TIME = "Last Login Time";

    @Override
    public User populate(User user, Map data) {
        Integer userId = Integer.parseInt(data.get(USER_ID).toString());
        user.setUserId(userId);
        user.setFirstName(data.get(FIRST_NAME).toString());
        user.setLastName(data.get(LAST_NAME).toString());
        user.setUsername(data.get(USERNAME).toString());
        user.setUserType(data.get(USER_TYPE).toString());
        user.setLastLoginTime(new DefaultConverter().converDateToIsoDate(data.get(LAST_LOGIN_TIME).toString()));
        return user;
    }

}


