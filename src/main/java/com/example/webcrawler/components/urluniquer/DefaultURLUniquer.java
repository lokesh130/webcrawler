package com.example.webcrawler.components.urluniquer;

import com.example.webcrawler.entities.URLCache;
import com.example.webcrawler.entities.enums.URLProtocol;
import com.example.webcrawler.service.URLCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDateTime;

@Slf4j
@Component
public class DefaultURLUniquer implements URLUniquer {
    private URLCacheService urlCacheService;

    public DefaultURLUniquer(@Autowired URLCacheService urlCacheService) {
        this.urlCacheService = urlCacheService;
    }

    @Override
    public Boolean isUnique(URL url) {
        URLProtocol protocol = getURLProtocol(url);
        String filteredUrl = url.toString().replaceAll("(\\w+://)", "");
        if(!urlCacheService.isURLPresent(filteredUrl)) {
            log.info("Unique URL : {}", url.toString());
            urlCacheService.persist(URLCache.builder()
                    .url(filteredUrl)
                    .protocol(protocol)
                    .createdAt(LocalDateTime.now())
                    .build());
            return true;
        }
        return false;
    }

    URLProtocol getURLProtocol(URL url) {
        URLProtocol protocol = URLProtocol.NONHTTP;
        if(url.toString().contains("http://")) {
            protocol = URLProtocol.HTTP;
        }
        else if(url.toString().contains("https://")) {
            protocol = URLProtocol.HTTPS;
        }
        return protocol;
    }
}
