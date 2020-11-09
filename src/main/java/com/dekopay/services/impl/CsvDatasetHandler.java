package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.DatasetHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CsvDatasetHandler extends DatasetHandler {
    @Override
    public ArrayList readDataset(String file) {
        //instantiate an ArrayList object so that we can add Map object into it
        ArrayList<Map> datasetList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = "";
            String cvsSplitBy = FileConstants.CSV_DELIMITER;

            //use the first line to set headers
            String[] lineHeaders = bufferedReader.readLine().split(cvsSplitBy);

            //start the reading each line after the header
            while ((line = bufferedReader.readLine()) != null) {
                //instantiate an datasetMap with Hash Map so thet we can add keypair value
                Map<String, String> datasetMap = new HashMap<>();

                // use comma as separator to split the entries
                String[] lineEntries = line.split(cvsSplitBy);

                for (int i = 0; i < lineEntries.length; i++) {
                    //dynamically assign header as key and entry as value
                    datasetMap.put(lineHeaders[i], lineEntries[i]);
                }

                //now it's time to add the dataset Map into the ArrayList
                datasetList.add(datasetMap);
            }
            return datasetList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
