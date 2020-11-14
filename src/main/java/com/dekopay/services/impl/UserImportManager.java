package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.User;
import com.dekopay.entities.user.impl.CsvUserDataPopulator;
import com.dekopay.entities.user.impl.JsonUserDataPopulator;
import com.dekopay.entities.user.impl.XmlUserDataPopulator;
import com.dekopay.services.ImportManager;
import com.dekopay.services.importation.impl.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 *
 */
public class UserImportManager implements ImportManager {

    public static final String DATA_TYPE = "users";

    @Override
    public Collection importData(){

        try {
            //import users
            //start getting all the user files
            List<String> fileList = new DefaultFileHandler().getFiles(DATA_TYPE);
            ArrayList datasets = new ArrayList();
            List<User> userList = new ArrayList<>();

            for (String file : fileList) {
                File fileObj = new File(file);

                //identify the file mime type
                DefaultFileHandler defaultFileHandler = new DefaultFileHandler();
                String fileType = defaultFileHandler.getContentType(fileObj);


                // start collection process for user
                switch (fileType) {
                    case FileConstants.CSV_MIME_TYPE:
                        //read CSV dataset
                        Import csvImport = new Import(new CsvMapping());
                        ArrayList<Map> csvDataset = csvImport.executeImport(file, "user");

                        for (Map userData : csvDataset) {
                            //Map mapUserData = (Map) userData;

                            //instantiate a user and populate it with the Csv populator
                            User user = new User();
                            CsvUserDataPopulator csvUserDataPopulator = new CsvUserDataPopulator();
                            User userObj = csvUserDataPopulator.populate(user, userData);

                            //Add user to the List
                            userList.add(userObj);
                        }
                        break;
                    case FileConstants.JSON_MIME_TYPE:
                        //read JSON dataset
                        Import jsonImport = new Import(new JsonMapping());
                        ArrayList<Map> jsonDataset = jsonImport.executeImport(file, "user");


                        for (Map userData : jsonDataset) {

                            //instantiate a user and populate it with the Csv populator
                            User user = new User();
                            JsonUserDataPopulator jsonUserDataPopulator = new JsonUserDataPopulator();
                            User userObj = jsonUserDataPopulator.populate(user, userData);

                            //Add user to the List
                            userList.add(userObj);
                        }
                        break;
                    case FileConstants.XML_MIME_TYPE:
                        //read XML dataset
                        Import xmlImport = new Import(new XmlMapping());
                        ArrayList<Map> xmlDataset = xmlImport.executeImport(file, "user");

                        for (Map userData : xmlDataset) {

                            //instantiate a user and populate it with the Csv populator
                            User user = new User();
                            XmlUserDataPopulator xmlUserDataPopulator = new XmlUserDataPopulator();
                            User userObj = xmlUserDataPopulator.populate(user, userData);

                            //Add user to the List
                            userList.add(userObj);
                        }
                        break;
                }

            }
            //sort User data by user id, this sort() method uses Strategy Pattern that takes comparator parameter
            //Based on different implementation of Cpomparator interfaces, the Objects are getting sorted in different ways
            userList.sort(Comparator.comparing(User::getUserId));
            return userList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
