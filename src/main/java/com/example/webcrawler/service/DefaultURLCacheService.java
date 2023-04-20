package com.example.webcrawler.service;

import com.example.webcrawler.daos.URLCacheDAO;
import com.example.webcrawler.entities.URLCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Objects;

@Component
public class DefaultURLCacheService implements URLCacheService {
    private URLCacheDAO urlCacheDAO;

    public DefaultURLCacheService(URLCacheDAO urlCacheDAO) {
        this.urlCacheDAO = urlCacheDAO;
    }

    @Override
    public Boolean isURLPresent(String url) {
        URLCache urlCache = urlCacheDAO.findByUrl(url);
        if(Objects.isNull(urlCache)) {
            return false;
        }
        return true;
    }

    public void persist(URLCache urlCache) {
        urlCacheDAO.save(urlCache);
    }
}
