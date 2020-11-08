package com.dekopay.services.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.entities.user.User;
import com.dekopay.entities.user.impl.CsvUserDataPopulator;
import com.dekopay.services.ExportManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvExportManager implements ExportManager {


    @Override
    public void exportData(Collection collection) throws IOException {

        CsvUserDataPopulator csvUserDataPopulator = new CsvUserDataPopulator();
        List<List<String>> dataLines = csvUserDataPopulator.mapUser(collection);
        this.writeToFile(dataLines, "users");

    }

    protected void writeToFile(List<List<String>> data, String fileName) throws IOException {
        FileWriter csvWriter = new FileWriter(FileConstants.USER_DIR + FileConstants.OUTPUT_FILE_DIR + "/" + fileName + FileConstants.CSV_EXTENSION);

        for (List<String> rowData : data) {
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

        System.out.println("Successfully Saved CSV file...");
    }


}
