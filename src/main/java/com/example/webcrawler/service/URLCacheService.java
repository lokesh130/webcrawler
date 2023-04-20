package com.example.webcrawler.service;

import com.example.webcrawler.entities.URLCache;

import java.net.URL;

public interface URLCacheService {
    public Boolean isURLPresent(String url);
    public void persist(URLCache urlCache);
}
