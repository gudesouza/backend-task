package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.entities.user.User;
import com.dekopay.services.exportation.FileHelper;
import com.dekopay.services.importation.impl.decorator.IndexHeaderDecorator;
import com.dekopay.services.importation.impl.decorator.UserCsvIndexHeaderDecorator;
import com.dekopay.services.importation.impl.decorator.UserIndexHeader;

import java.util.*;

public class CsvFileUserDecorator extends UserDecorator {

    public CsvFileUserDecorator(FileHelper fileHelper) {
        super(fileHelper);
    }

    @Override
    public void doWrite(Object data, String fileName) {
        List list = new ArrayList();

        //add the csv header
        //set the indexes before assigning them
        setIndexes();
        //setting thi way make sure the header/index matches sequence the values when is set
        list.add(Arrays.asList(indexes.get("USER_ID"),indexes.get("FIRST_NAME"),indexes.get("LAST_NAME"),indexes.get("USERNAME"),indexes.get("USER_TYPE"),indexes.get("LAST_LOGIN_TIME")));

        //add all the users (Id needs to convert to string)
        for (User user : (Collection<User>)data) {
            list.add(Arrays.asList(user.getUserId().toString(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getUserType(), user.getLastLoginTime()));
        }

        List<List<String>> dataLines = list;
        //return dataLines;
        decoratedFile.doWrite(dataLines, fileName);
    }

    @Override
    public void setIndexes() {
        IndexHeaderDecorator userCsvIndexHeaderDecorator = new IndexHeaderDecorator(new UserCsvIndexHeaderDecorator(new UserIndexHeader()));
        Map indexes = userCsvIndexHeaderDecorator.getData();
        super.indexes = indexes;
    }
}
