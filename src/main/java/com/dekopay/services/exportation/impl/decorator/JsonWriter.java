package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.CsvUserDataPopulator;
import com.dekopay.entities.user.impl.JsonUserDataPopulator;
import com.dekopay.services.exportation.FileHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class JsonWriter implements FileHelper {

    @Override
    public void doWrite(Collection data, String fileName, List headers) {

        //start exporting
        System.out.println("Start Writing to Json...");
        /**
         * @// TODO: 13/11/2020 need to refactor this implementation for populating the data
         */
        JsonUserDataPopulator jsonUserDataPopulator = new JsonUserDataPopulator();
        List<List<String>> list = jsonUserDataPopulator.mapUser(data, headers);

        try {
            //instantiate the file writer
            FileWriter jsonWriter = new FileWriter(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.JSON_EXTENSION);

            //instantiate object mapper prettify the json
            ObjectMapper mapper = new ObjectMapper();
            String jsonPretty = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
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
