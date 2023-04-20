package com.example.webcrawler.components.webcrawler;

import com.example.webcrawler.components.linkextractor.LinkExtractor;
import com.example.webcrawler.components.urlfrontier.URLFrontier;
import com.example.webcrawler.components.urluniquer.URLUniquer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class DefaultWebCrawler implements WebCrawler {
    private LinkExtractor linkExtractor;
    private URLFrontier urlFrontier;
    private URLUniquer urlUniquer;

    public DefaultWebCrawler(@Autowired LinkExtractor linkExtractor, @Autowired URLFrontier urlFrontier, @Autowired URLUniquer urlUniquer) {
        this.linkExtractor = linkExtractor;
        this.urlFrontier = urlFrontier;
        this.urlUniquer = urlUniquer;
    }

    @Override
    public void crawl(URL seedURL, Integer maxDepth) {
        urlFrontier.addURL(seedURL);
        Integer counter = 0;
        while(counter < maxDepth) {
            URL url = urlFrontier.getURL();
            if(Objects.isNull(url)) {
                break;
            }
            try {
                List<URL> urlList = linkExtractor.extract(new BufferedReader(new InputStreamReader(url.openStream())));
                urlList.forEach(url1 -> {
                    if(urlUniquer.isUnique(url1)) {
                        urlFrontier.addURL(url1);
                    }
                });
                counter++;
            }
            catch (FileNotFoundException exception) {
                continue;
            }
            catch (IOException exception) {
                continue;
            }
        }



    }
}
