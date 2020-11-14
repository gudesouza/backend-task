package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.User;
import com.dekopay.entities.user.DataPopulator;
import com.dekopay.services.datasetformation.impl.DefaultConverter;

import java.util.Map;

public class XmlUserDataPopulator extends DataPopulator {

    private static final String USERS = "users";
    private static final String USER = "user";
    private static final String USER_ID = "userid";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "surname";
    private static final String USERNAME = "username";
    private static final String USER_TYPE = "type";
    private static final String LAST_LOGIN_TIME = "lastlogintime";


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
