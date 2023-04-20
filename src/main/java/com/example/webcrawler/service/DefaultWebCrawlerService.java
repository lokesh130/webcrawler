package com.example.webcrawler.service;

import com.example.webcrawler.components.webcrawler.WebCrawler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Slf4j
@Component
public class DefaultWebCrawlerService implements WebCrawlerService {
    private WebCrawler webCrawler;

    public DefaultWebCrawlerService(@Autowired WebCrawler webCrawler) {
        this.webCrawler = webCrawler;
    }

    @Override
    public void crawl(URL seedURL, Integer maxDepth) throws IOException {
        webCrawler.crawl(seedURL, maxDepth);
    }
}
