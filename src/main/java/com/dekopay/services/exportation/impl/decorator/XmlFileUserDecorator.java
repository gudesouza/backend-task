package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.services.exportation.FileHelper;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class XmlFileUserDecorator extends UserDecorator {

    private static final String USER_ID = "userid";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "surname";
    private static final String USERNAME = "username";
    private static final String USER_TYPE = "type";
    private static final String LAST_LOGIN_TIME = "lastlogintime";

    public XmlFileUserDecorator(FileHelper fileHelper) {
        super(fileHelper);
    }

    @Override
    public void doWrite(Collection data, String fileName, List headers) {
        decoratedFile.doWrite(data, fileName, getXmlHeaders());
    }

    public List getXmlHeaders() {
        return Arrays.asList(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, USER_TYPE, LAST_LOGIN_TIME);
    }

}
