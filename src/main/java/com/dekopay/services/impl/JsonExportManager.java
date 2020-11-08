package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.JsonUserDataPopulator;
import com.dekopay.services.ExportManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class JsonExportManager implements ExportManager {
    @Override
    public void exportData(Collection collection) throws IOException {

        JsonUserDataPopulator jsonUserDataPopulator = new JsonUserDataPopulator();
        //List<List<String>> dataLines = jsonUserDataPopulator.mapUser(collection);
        List<List<String>> list = jsonUserDataPopulator.mapUser(collection);
        this.writeToFile(list, "users");


    }

    protected void writeToFile(List<List<String>> data, String fileName) throws IOException {
        FileWriter jsonWriter = new FileWriter(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.JSON_EXTENSION);
        //jsonWriter.write(data.toString());

        ObjectMapper mapper = new ObjectMapper();
        String jsonPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        jsonWriter.write(jsonPretty);

        jsonWriter.flush();
        jsonWriter.close();

        System.out.println("Successfully Saved JSON file...");
    }
}
