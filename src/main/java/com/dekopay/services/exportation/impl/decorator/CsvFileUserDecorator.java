package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.entities.user.User;
import com.dekopay.services.exportation.FileHelper;

import java.util.ArrayList;
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
    public void doWrite(Object data, String fileName, List headers) {
        List list = new ArrayList();

        //add the csv header
        list.add(getCsvHeaders());

        //add all the users (Id needs to convert to string)
        for (User user : (Collection<User>)data) {
            list.add(Arrays.asList(user.getUserId().toString(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getUserType(), user.getLastLoginTime()));
        }

        List<List<String>> dataLines = list;
        //return dataLines;
        decoratedFile.doWrite(dataLines, fileName, getCsvHeaders());
    }

    /**
     * This can be used by populator
     * @return
     */
    public List getCsvHeaders() {
        return Arrays.asList(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, LAST_LOGIN_TIME);
    }

}
