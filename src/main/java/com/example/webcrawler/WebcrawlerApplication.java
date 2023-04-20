package com.example.webcrawler;

import com.example.webcrawler.service.WebCrawlerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class WebcrawlerApplication {

    public static void main(String[] args) throws IOException {
       SpringApplication.run(WebcrawlerApplication.class, args);
    }

}
