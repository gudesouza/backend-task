package com.dekopay.services.datasetformation.impl;

import com.dekopay.services.datasetformation.DataFormatHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DefaultConverter extends DataFormatHandler {

    @Override
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
