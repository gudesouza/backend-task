package com.dekopay.services.importation.impl.decorator;

import com.dekopay.services.importation.IndexHeader;

import java.util.Map;

public class UserJsonIndexHeaderDecorator extends IndexHeaderDecorator {

    public UserJsonIndexHeaderDecorator(IndexHeader decoratedIndexHeader) {
        super(decoratedIndexHeader);
    }

    @Override
    public Map<String, String> getData() {
        return formatIndex(super.getData());
    }

    private Map<String, String> formatIndex(Map<String, String> indexData) {
        indexData.put("USER_ID", "user_id");
        indexData.put("FIRST_NAME", "first_name");
        indexData.put("LAST_NAME", "last_name");
        indexData.put("USERNAME","username");
        indexData.put("USER_TYPE", "user_type");
        indexData.put("LAST_LOGIN_TIME", "last_login_time");
        return indexData;
    }
}