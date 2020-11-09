package com.dekopay.services;

import java.io.IOException;
import java.util.Collection;

/**
 * Responsible to import data, subclass class can be implemented and inherit importData
 * to take take of different import data entities such as User(in this case), Address, etc...
 */
public interface ImportManager {
    public Collection importData() throws IOException;
}
