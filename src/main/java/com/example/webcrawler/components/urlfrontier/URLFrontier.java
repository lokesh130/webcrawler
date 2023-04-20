package com.example.webcrawler.components.urlfrontier;

import java.net.URL;
import java.util.List;

public interface URLFrontier {
    public void addURL(URL url);
    public void addURLs(List<URL> urlList);
    public URL getURL();
}
