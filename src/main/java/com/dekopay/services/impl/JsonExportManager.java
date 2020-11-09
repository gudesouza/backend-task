package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.JsonUserDataPopulator;
import com.dekopay.services.ExportManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class JsonExportManager implements ExportManager {

    @Override
    public void exportData(Collection collection) {
        //start exporting
        JsonUserDataPopulator jsonUserDataPopulator = new JsonUserDataPopulator();
        List<List<String>> list = jsonUserDataPopulator.mapUser(collection);
        this.writeToFile(list, "users");

    }

    public void writeToFile(List<List<String>> data, String fileName) {

        try {
            //instantiate the file writer
            FileWriter jsonWriter = new FileWriter(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.JSON_EXTENSION);

            //instantiate object mapper prettify the json
            ObjectMapper mapper = new ObjectMapper();
            String jsonPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
            jsonWriter.write(jsonPretty);

            //flush and close
            jsonWriter.flush();
            jsonWriter.close();

            System.out.println("Successfully Saved JSON file...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
