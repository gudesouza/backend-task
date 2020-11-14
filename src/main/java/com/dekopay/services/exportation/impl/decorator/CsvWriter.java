package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.CsvUserDataPopulator;
import com.dekopay.services.exportation.FileHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class CsvWriter implements FileHelper {

    @Override
    public void doWrite(Collection data, String fileName, List headers) {

        //start writing
        System.out.println("Start Writing to CSV...");
        /**
         * @// TODO: 13/11/2020 need to refactor this implementation for populating the data
         */
        CsvUserDataPopulator csvUserDataPopulator = new CsvUserDataPopulator();
        List<List<String>> list = csvUserDataPopulator.mapUser(data, headers);

        try {
            FileWriter csvWriter = new FileWriter(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.CSV_EXTENSION);

            for (List<String> rowData : list) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("Successfully Saved CSV file...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
