package com.dekopay.services;

import java.io.IOException;
import java.util.Collection;

public interface ExportManager {
    public void exportData(Collection collection) throws IOException;
}
