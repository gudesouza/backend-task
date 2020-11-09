package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.DatasetHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonDatasetHandler extends DatasetHandler {

    @Override
    public ArrayList readDataset(String file) {
        //instantiate an ArrayList object so that we can add Map object into it
        ArrayList<Map> datasetList = new ArrayList<>();

        try {
            //instantiate Json parser and start parsing file reader to load json file
            JSONParser parser = new JSONParser();
            Object object = parser.parse(new FileReader(file));

            //because the json file is an array of objects so we use Json Array so we can loop through
            JSONArray jsonList = (JSONArray) object;
            for (Object lineItem : jsonList) {
                //instantiate an datasetMap with Hash Map so thet we can add keypair value
                Map<String, String> datasetMap = new HashMap<>();
                JSONObject jsonObject = (JSONObject) lineItem;

                //dynamically assign all the element so we can get all the fields from the json file
                for (Object keyObject : jsonObject.keySet()) {
                    //start assigning the keypair field value
                    String key = (String) keyObject;
                    Object valueObject = jsonObject.get(key);
                    datasetMap.put(key, valueObject.toString());
                }

                //now it's time to add the dataset Map into the ArrayList
                datasetList.add(datasetMap);
            }
            return datasetList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
