package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.services.exportation.FileHelper;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
    public void doWrite(Collection data, String fileName, List headers) {
        decoratedFile.doWrite(data, fileName, getJsonHeaders());
    }

    public List getJsonHeaders() {
        return Arrays.asList(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, LAST_LOGIN_TIME);
    }

}
