package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.User;
import com.dekopay.entities.user.impl.CsvUserDataPopulator;
import com.dekopay.entities.user.impl.JsonUserDataPopulator;
import com.dekopay.entities.user.impl.XmlUserDataPopulator;
import com.dekopay.services.ImportManager;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserImportManager implements ImportManager {

    public static final String DATA_TYPE = "users";

    @Override
    public Collection importData() throws IOException {
        //import users
        //get all the user files
        List<String> fileList = new DefaultFileHandler().getFiles(DATA_TYPE);
        ArrayList datasets = new ArrayList();
        List<User> userList = new ArrayList<>();

        for (String file : fileList) {
            File fileObj = new File(file);

            //identify the file mime type
            DefaultFileHandler defaultFileHandler = new DefaultFileHandler();
            String fileType = defaultFileHandler.getContentType(fileObj);
            System.out.println(fileType);

            // start collection process for user
            switch (fileType) {
                case FileConstants.CSV_MIME_TYPE:
                    //get CSV dataset
                    ArrayList csvDataset = new CsvDatasetHandler().readDataset(file);

                    for (Map userData : ((List<Map>) csvDataset)) {
                        //Map mapUserData = (Map) userData;

                        //instantiate a user and populate is with the Csv populator
                        User user = new User();
                        CsvUserDataPopulator csvUserDataPopulator = new CsvUserDataPopulator();
                        User userObj = csvUserDataPopulator.populate(user, userData);

                        //Add user to the List
                        userList.add(userObj);
                    }
                    System.out.println("CSV");
                    break;
                case FileConstants.JSON_MIME_TYPE:
                    //get JSON dataset
                    ArrayList jsonDataset = new JsonDatasetHandler().readDataset(file);

                    for (Map userData : ((List<Map>) jsonDataset)) {

                        //instantiate a user and populate is with the Csv populator
                        User user = new User();
                        JsonUserDataPopulator jsonUserDataPopulator = new JsonUserDataPopulator();
                        User userObj = jsonUserDataPopulator.populate(user, userData);

                        //Add user to the List
                        userList.add(userObj);
                    }
                    System.out.println("JSON");
                    break;
                case FileConstants.XML_MIME_TYPE:
                    //get XML dataset
                    ArrayList xmlDataset = new XmlDatasetHandler().readDataset(file);

                    for (Map userData : ((List<Map>) xmlDataset)) {

                        //instantiate a user and populate is with the Csv populator
                        User user = new User();
                        XmlUserDataPopulator xmlUserDataPopulator = new XmlUserDataPopulator();
                        User userObj = xmlUserDataPopulator.populate(user, userData);

                        //Add user to the List
                        userList.add(userObj);
                    }
                    System.out.println("XML");
                    break;
            }

        }
        for (Object dataset : datasets) {
            System.out.println(dataset);
        }
        return userList;
    }

}
