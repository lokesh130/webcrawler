package com.example.webcrawler.components.webcrawler;

import java.io.IOException;
import java.net.URL;

public interface WebCrawler {
    public void crawl(URL seedURL, Integer maxDepth) throws IOException;
}
