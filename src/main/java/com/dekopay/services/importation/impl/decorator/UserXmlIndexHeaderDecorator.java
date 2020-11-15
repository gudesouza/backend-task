package com.dekopay.services.importation.impl.decorator;

import com.dekopay.services.importation.IndexHeader;

import java.util.Map;

public class UserXmlIndexHeaderDecorator extends IndexHeaderDecorator {

    public UserXmlIndexHeaderDecorator(IndexHeader decoratedIndexHeader) {
        super(decoratedIndexHeader);
    }

    @Override
    public Map<String, String> getData() {
        return formatIndex(super.getData());
    }

    private Map<String, String> formatIndex(Map<String, String> indexData) {
        indexData.put("USER_ID", "userid");
        indexData.put("FIRST_NAME", "firstname");
        indexData.put("LAST_NAME", "surname");
        indexData.put("USERNAME","username");
        indexData.put("USER_TYPE", "type");
        indexData.put("LAST_LOGIN_TIME", "lastlogintime");
        return indexData;
    }
}