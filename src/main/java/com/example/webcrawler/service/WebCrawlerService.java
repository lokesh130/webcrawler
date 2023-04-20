package com.example.webcrawler.service;

import java.io.IOException;
import java.net.URL;

public interface WebCrawlerService {
    public void crawl(URL seedURL, Integer maxDepth) throws IOException;
}
