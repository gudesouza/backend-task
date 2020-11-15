package com.dekopay.services.importation.impl.decorator;

import com.dekopay.services.importation.IndexHeader;

import java.util.HashMap;
import java.util.Map;

public class UserCsvIndexHeaderDecorator extends IndexHeaderDecorator {

    public UserCsvIndexHeaderDecorator(IndexHeader decoratedIndexHeader) {
        super(decoratedIndexHeader);
    }

    @Override
    public Map<String, String> getData() {
        return formatIndex(super.getData());
    }

    private Map<String, String> formatIndex(Map<String, String> indexData) {
        indexData.put("USER_ID", "User ID");
        indexData.put("FIRST_NAME", "First Name");
        indexData.put("LAST_NAME", "Last Name");
        indexData.put("USERNAME","Username");
        indexData.put("USER_TYPE", "User Type");
        indexData.put("LAST_LOGIN_TIME", "Last Login Time");
        return indexData;
    }
}
