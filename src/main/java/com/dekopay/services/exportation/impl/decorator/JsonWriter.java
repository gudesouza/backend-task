package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.exportation.FileHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter implements FileHelper {

    @Override
    public void doWrite(Object data, String fileName) {

        //start exporting
        System.out.println("Start Writing to Json..."  + data.toString());

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
