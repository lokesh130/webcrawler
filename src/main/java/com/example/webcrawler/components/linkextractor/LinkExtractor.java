package com.example.webcrawler.components.linkextractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface LinkExtractor {
    public List<URL> extract(BufferedReader bufferedReader) throws IOException;
}
