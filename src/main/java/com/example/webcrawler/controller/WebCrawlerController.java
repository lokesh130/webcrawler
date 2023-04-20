package com.example.webcrawler.controller;

import com.example.webcrawler.service.WebCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

@RestController
public class WebCrawlerController {
    private WebCrawlerService webCrawlerService;

    public WebCrawlerController(@Autowired WebCrawlerService webCrawlerService) {
        this.webCrawlerService = webCrawlerService;
    }

    @GetMapping("crawl")
    public void crawl(@RequestParam("seed_url") String seedUrl,@RequestParam("max_depth") Integer maxDepth) throws IOException {
        webCrawlerService.crawl(new URL(seedUrl), maxDepth);
    }

    @GetMapping("healthcheck")
    public String crawl()  {
        return "Server is Healthy";
    }
}
