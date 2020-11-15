package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.entities.user.User;
import com.dekopay.services.exportation.FileHelper;
import com.dekopay.services.importation.impl.decorator.IndexHeaderDecorator;
import com.dekopay.services.importation.impl.decorator.UserCsvIndexHeaderDecorator;
import com.dekopay.services.importation.impl.decorator.UserIndexHeader;
import com.dekopay.services.importation.impl.decorator.UserJsonIndexHeaderDecorator;
import org.json.simple.JSONArray;

import java.util.*;

public class JsonFileUserDecorator extends UserDecorator {

    public JsonFileUserDecorator(FileHelper fileHelper) {
        super(fileHelper);
    }

    @Override
    public void doWrite(Object data, String fileName) {

        //set the indexes before assigning them
        setIndexes();

        JSONArray list = new JSONArray();
        for (User user : (Collection<User>)data) {
            //JSONObject jsonUser = new JSONObject();
            Map jsonUser = new LinkedHashMap();
            jsonUser.put(indexes.get("USER_ID"), user.getUserId().toString()); //(Id needs to convert to string)
            jsonUser.put(indexes.get("FIRST_NAME"), user.getFirstName());
            jsonUser.put(indexes.get("LAST_NAME"), user.getLastName());
            jsonUser.put(indexes.get("USERNAME"), user.getUsername());
            jsonUser.put(indexes.get("USER_TYPE"), user.getUserType());
            jsonUser.put(indexes.get("LAST_LOGIN_TIME"), user.getLastLoginTime());
            list.add(jsonUser);
        }

        decoratedFile.doWrite(list, fileName);
    }

    @Override
    public void setIndexes() {
        IndexHeaderDecorator userJsonIndexHeaderDecorator = new IndexHeaderDecorator(new UserJsonIndexHeaderDecorator(new UserIndexHeader()));
        Map indexes = userJsonIndexHeaderDecorator.getData();
        super.indexes = indexes;
    }

}
