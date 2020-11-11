package com.dekopay.services.exportation.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.JsonUserDataPopulator;
import com.dekopay.services.exportation.JsonExporter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class UserJsonExporter implements JsonExporter {

    @Override
    public void export(Collection data) {
        System.out.println("Start Exporting User JSON... ");
        //start exporting
        JsonUserDataPopulator jsonUserDataPopulator = new JsonUserDataPopulator();
        List<List<String>> list = jsonUserDataPopulator.mapUser(data);
        this.writeToFile(list, FileConstants.USERS_EXPORT_NAME);
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
