package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.entities.user.User;
import com.dekopay.services.exportation.FileHelper;
import org.json.simple.JSONArray;

import java.util.*;

public class JsonFileUserDecorator extends UserDecorator {

    private static final String USER_ID = "user_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String USERNAME = "username";
    private static final String USER_TYPE = "user_type";
    private static final String LAST_LOGIN_TIME = "last_login_time";

    public JsonFileUserDecorator(FileHelper fileHelper) {
        super(fileHelper);
    }

    @Override
    public void doWrite(Object data, String fileName, List headers) {

        JSONArray list = new JSONArray();
        for (User user : (Collection<User>)data) {
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

        decoratedFile.doWrite(list, fileName, getJsonHeaders());
    }

    /**
     * This can be used by populator
     * @return
     */
    public List getJsonHeaders() {
        return Arrays.asList(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, LAST_LOGIN_TIME);
    }

}
