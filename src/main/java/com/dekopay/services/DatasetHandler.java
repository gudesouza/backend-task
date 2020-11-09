package com.dekopay.services;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * DatasetHandler is responsible read dataset of a given file, as we now have three different types of files, the dataset readings must
 * be handle differently, therefore the implementation subclasses are CsvDatasetHandler, JsonDatasetHandler and XmlDatasetHandler, but more types
 * can be implemented. Also responsible to convert String Date to ISO8601 Data string
 */
abstract public class DatasetHandler {
    /**
     * Abstract method responsible read dataset of a given file
     * @param file
     * @return
     */
    abstract public ArrayList readDataset(String file);

    /**
     * Responsible to convert String Date to ISO8601 Data string
     * @param dateInString
     * @return
     */
    public String converDateToIsoDate(String dateInString) {
        try {
            //convert string to Date
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss", Locale.UK);
            Date date = formatter.parse(dateInString);

            //convert Date into iso date string
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); //2017-02-16T21:00:00.000+01:00 | 2015-01-12T12:01:34+00:00
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
            String isoDate = simpleDateFormat.format(date);

            return isoDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
