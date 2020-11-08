package com.dekopay.services;


import com.dekopay.entities.User;
import com.dekopay.services.impl.CsvDatasetHandler;
import com.dekopay.services.impl.DefaultFileHandler;
import com.dekopay.services.impl.JsonDatasetHandler;
import com.dekopay.services.impl.XmlDatasetHandler;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataManagerTest {
    @Test
    public void testUserData() throws IOException {
        List<String> fileList = new DefaultFileHandler().getFiles("users`");
        ArrayList datasets = new ArrayList();
        for (String file : fileList) {
            File fileObj = new File(file);

            DefaultFileHandler defaultFileHandler = new DefaultFileHandler();
            String fileType = defaultFileHandler.getContentType(fileObj);
            System.out.println(fileType);
            switch (fileType) {
                case "text/csv":
                    //get CSV dataset

                    //datasets.add(new CsvDatasetHandler().readDataset(file));
                    ArrayList csvDataset = new CsvDatasetHandler().readDataset(file);
                    for (Object userData : csvDataset) {
                        Map mapUserData = (Map) userData;
                        System.out.println(mapUserData.get("User ID"));
                        //assign to an User Oblect
                        User user = new User();
                        try {

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //Add to the array
                    }
                    System.out.println("CSV");
                    break;
                case "application/json":
                    //get JSON dataset
                    datasets.add(new JsonDatasetHandler().readDataset(file));
                    System.out.println("JSON");
                    break;
                case "application/xml":
                    //get XML dataset
                    datasets.add(new XmlDatasetHandler().readDataset(file));
                    System.out.println("XML");
                    break;
            }

        }
        for (Object dataset : datasets) {
            System.out.println(dataset);
        }
    }
    /*public void mergeDatasets (ArrayList datasets) {
        ArrayList mergedDataset = new ArrayList();
        for (Object dataset : datasets) {

        }
    }*/
}
