package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.services.exportation.FileHelper;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CsvFileUserDecorator extends UserDecorator {

    private static final String USER_ID = "User ID";
    private static final String FIRST_NAME = "First Name";
    private static final String LAST_NAME = "Last Name";
    private static final String USERNAME = "Username";
    private static final String USER_TYPE = "User Type";
    private static final String LAST_LOGIN_TIME = "Last Login Time";

    public CsvFileUserDecorator(FileHelper fileHelper) {
        super(fileHelper);
    }

    @Override
    public void doWrite(Collection data, String fileName, List header) {
        decoratedFile.doWrite(data, fileName, getCsvHeaders());
    }

    public List getCsvHeaders() {
        return Arrays.asList(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, LAST_LOGIN_TIME);
    }

}
