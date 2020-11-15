package com.dekopay.services.exportation.impl;

import com.dekopay.constants.FileConstants;
import com.dekopay.services.exportation.FileHelper;
import com.dekopay.services.exportation.JsonExporter;
import com.dekopay.services.exportation.impl.decorator.JsonFileUserDecorator;
import com.dekopay.services.exportation.impl.decorator.JsonWriter;

import java.util.Collection;

public class UserJsonExporter implements JsonExporter {

    @Override
    public void export(Collection data) {

        System.out.println("Start Exporting Process JSON... ");

        //start exporting
        FileHelper jsonWriter = new JsonWriter();
        FileHelper jsonUserFile = new JsonFileUserDecorator(jsonWriter);
        jsonUserFile.doWrite(data,  FileConstants.USERS_EXPORT_NAME);

    }
}
