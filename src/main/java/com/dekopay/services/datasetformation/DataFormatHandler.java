package com.dekopay.services.datasetformation;

import java.text.SimpleDateFormat;
import java.util.*;


/**
 * DatasetHandler is responsible to read dataset of a given file, as we now have three different types of files, the dataset readings must
 * be handle differently, therefore the implementation subclasses are CsvDatasetHandler, JsonDatasetHandler and XmlDatasetHandler, but more types
 * can be implemented. Also responsible to convert String Date to ISO8601 Data string
 */
abstract public class DataFormatHandler {

    /**
     * Responsible to convert String Date to ISO8601 Data string
     * @param dateInString
     * @return
     */
    abstract public String converDateToIsoDate(String dateInString);
}
