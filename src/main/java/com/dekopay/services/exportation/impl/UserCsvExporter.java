package com.dekopay.services.exportation.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.exportation.CsvExporter;
import com.dekopay.services.exportation.FileHelper;
import com.dekopay.services.exportation.impl.decorator.CsvFileUserDecorator;
import com.dekopay.services.exportation.impl.decorator.CsvWriter;

import java.util.Collection;

public class UserCsvExporter implements CsvExporter {

    @Override
    public void export(Collection data) {

        System.out.println("Start Exporting Process Csv... ");

        //start exporting
        FileHelper csvWriter = new CsvWriter();
        FileHelper csvUserFile = new CsvFileUserDecorator(csvWriter);
        csvUserFile.doWrite(data, FileConstants.USERS_EXPORT_NAME, null);

    }

}
