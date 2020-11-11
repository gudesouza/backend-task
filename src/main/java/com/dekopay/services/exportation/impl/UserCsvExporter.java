package com.dekopay.services.exportation.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.impl.CsvUserDataPopulator;
import com.dekopay.services.exportation.CsvExporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class UserCsvExporter implements CsvExporter {

    @Override
    public void export(Collection data) {
        System.out.println("Start Exporting User CSV...");
        //start exporting
        CsvUserDataPopulator csvUserDataPopulator = new CsvUserDataPopulator();
        List<List<String>> dataLines = csvUserDataPopulator.mapUser(data);
        this.writeToFile(dataLines, FileConstants.USERS_EXPORT_NAME);
    }

    /**
     * Responsible write to file
     * @param data
     * @param fileName
     * @throws IOException
     */
    protected void writeToFile(List<List<String>> data, String fileName) {

        try {
            FileWriter csvWriter = new FileWriter(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.CSV_EXTENSION);

            for (List<String> rowData : data) {
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
