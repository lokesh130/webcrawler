package com.example.webcrawler.components.urlfrontier;

import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
public class DefaultURLFrontier implements URLFrontier {
    Queue<URL> urlList;

    public DefaultURLFrontier() {
        urlList = new LinkedList<>();
    }

    @Override
    public void addURL(URL url) {
        urlList.add(url);
    }

    @Override
    public void addURLs(List<URL> urlList) {
        this.urlList.addAll(urlList);
    }

    @Override
    public URL getURL() {
        if(urlList.isEmpty()) {
            return null;
        }
        return urlList.remove();
    }
}
