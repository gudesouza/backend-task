package com.dekopay.services;

import com.dekopay.services.impl.XmlDatasetHandler;

import java.text.SimpleDateFormat;
import java.util.*;

abstract public class DatasetHandler {
    abstract public ArrayList readDataset(String file);

    public String converDateToIsoDate(String dateInString) {
        try {
            //convert string to Date
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss", Locale.UK);
            Date date = formatter.parse(dateInString);

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
