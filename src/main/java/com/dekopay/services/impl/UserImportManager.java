package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.User;
import com.dekopay.entities.user.impl.UserDataPopulator;
import com.dekopay.services.ImportManager;
import com.dekopay.services.importation.impl.*;
import com.dekopay.services.importation.impl.decorator.*;

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

                        //get index header for user
                        //UserCsvIndexHeaderDecorator userCsvIndexHeaderDecorator = new UserCsvIndexHeaderDecorator(new UserIndexHeader());
                        IndexHeaderDecorator userCsvIndexHeaderDecorator = new IndexHeaderDecorator(new UserCsvIndexHeaderDecorator(new UserIndexHeader()));
                        Map userCsvIndexHeader = userCsvIndexHeaderDecorator.getData();

                        for (Map userData : csvDataset) {

                            //instantiate a user and populate it with the Csv populator
                            User user = new User();
                            UserDataPopulator userDataPopulator = new UserDataPopulator();
                            User userObj = userDataPopulator.populate(user, userData, userCsvIndexHeader);

                            //Add user to the List
                            userList.add(userObj);
                        }
                        break;
                    case FileConstants.JSON_MIME_TYPE:
                        //read JSON dataset
                        Import jsonImport = new Import(new JsonMapping());
                        ArrayList<Map> jsonDataset = jsonImport.executeImport(file, "user");

                        //get index header for user
                        //UserJsonIndexHeaderDecorator userJsonIndexHeaderDecorator = new UserJsonIndexHeaderDecorator(new UserIndexHeader());
                        IndexHeaderDecorator userJsonIndexHeaderDecorator = new IndexHeaderDecorator(new UserJsonIndexHeaderDecorator(new UserIndexHeader()));
                        Map userJsonIndexHeader = userJsonIndexHeaderDecorator.getData();

                        for (Map userData : jsonDataset) {

                            //instantiate a user and populate it with the Csv populator
                            User user = new User();
                            UserDataPopulator userDataPopulator = new UserDataPopulator();
                            User userObj = userDataPopulator.populate(user, userData, userJsonIndexHeader);

                            //Add user to the List
                            userList.add(userObj);
                        }
                        break;
                    case FileConstants.XML_MIME_TYPE:
                        //read XML dataset
                        Import xmlImport = new Import(new XmlMapping());
                        ArrayList<Map> xmlDataset = xmlImport.executeImport(file, "user");

                        IndexHeaderDecorator userXmlIndexHeaderDecorator = new IndexHeaderDecorator(new UserXmlIndexHeaderDecorator(new UserIndexHeader()));
                        Map userXmlIndexHeader = userXmlIndexHeaderDecorator.getData();

                        for (Map userData : xmlDataset) {

                            //instantiate a user and populate it with the Csv populator
                            User user = new User();
                            UserDataPopulator userDataPopulator = new UserDataPopulator();
                            User userObj = userDataPopulator.populate(user, userData, userXmlIndexHeader);

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
