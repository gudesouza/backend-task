package com.dekopay.services;

import java.io.IOException;
import java.util.Collection;

/**
 * Responsible to import data
 */
public interface ImportManager {
    public Collection importData() throws IOException;
}
