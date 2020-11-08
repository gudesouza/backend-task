package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.User;
import com.dekopay.entities.user.UserDataPopulator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
        JSONArray list = new JSONArray();
        for (User user : collection) {
            //JSONObject jsonUser = new JSONObject();
            Map jsonUser = new LinkedHashMap();
            jsonUser.put(USER_ID, user.getUserId());
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
