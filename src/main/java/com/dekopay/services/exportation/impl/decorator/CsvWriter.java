package com.dekopay.services.exportation.impl.decorator;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.exportation.FileHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter implements FileHelper {

    @Override
    public void doWrite(Object data, String fileName) {

        //start writing
        System.out.println("Start Writing to CSV..." + data.toString());

        try {
            FileWriter csvWriter = new FileWriter(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.CSV_EXTENSION);

            for (List<String> rowData : (List<List<String>>)data) {
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
