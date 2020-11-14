package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.User;
import com.dekopay.entities.user.UserDataPopulator;
import com.dekopay.services.datasetformation.impl.DefaultConverter;
import org.json.simple.JSONArray;

import java.util.*;

public class JsonUserDataPopulator extends UserDataPopulator {

    private static final String USER_ID = "user_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String USERNAME = "username";
    private static final String USER_TYPE = "user_type";
    private static final String LAST_LOGIN_TIME = "last_login_time";

    @Override
    public User populate(User user, Map data) {
        Integer userId = Integer.parseInt(data.get(USER_ID).toString());
        user.setUserId(userId);
        user.setFirstName(data.get(FIRST_NAME).toString());
        user.setLastName( data.get(LAST_NAME).toString());
        user.setUsername(data.get(USERNAME).toString());
        user.setUserType(data.get(USER_TYPE).toString());
        user.setLastLoginTime(new DefaultConverter().converDateToIsoDate(data.get(LAST_LOGIN_TIME).toString()));
        return user;
    }

    @Override
    public List<List<String>> mapUser(Collection<User> collection, List headers) {

        JSONArray list = new JSONArray();
        for (User user : collection) {
            //JSONObject jsonUser = new JSONObject();
            Map jsonUser = new LinkedHashMap();
            jsonUser.put(USER_ID, user.getUserId().toString()); //(Id needs to convert to string)
            jsonUser.put(FIRST_NAME, user.getFirstName());
            jsonUser.put(LAST_NAME, user.getLastName());
            jsonUser.put(USERNAME, user.getUsername());
            jsonUser.put(USER_TYPE, user.getUserType());
            jsonUser.put(LAST_LOGIN_TIME, user.getLastLoginTime());
            list.add(jsonUser);
        }
        return list;
    }
}
