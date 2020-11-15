package com.dekopay.entities.user.impl;

import com.dekopay.entities.user.DataPopulator;
import com.dekopay.entities.user.User;
import com.dekopay.services.datasetformation.impl.DefaultConverter;
import java.util.Map;

public class UserDataPopulator extends DataPopulator {

    @Override
    public User populate(Object object, Map<String, String> data, Map<String, String> indexHeader) {

        //type cast object
        User user = (User) object;

        Integer userId = Integer.parseInt(data.get(indexHeader.get("USER_ID")));
        user.setUserId(userId);
        user.setFirstName(data.get(indexHeader.get("FIRST_NAME")));
        user.setLastName(data.get(indexHeader.get("LAST_NAME")));
        user.setUsername(data.get(indexHeader.get("USERNAME")));
        user.setUserType(data.get(indexHeader.get("USER_TYPE")));
        user.setLastLoginTime(new DefaultConverter().converDateToIsoDate(data.get(indexHeader.get("LAST_LOGIN_TIME"))));
        return user;
    }
}

