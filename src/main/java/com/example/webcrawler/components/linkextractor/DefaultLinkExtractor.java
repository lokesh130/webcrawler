package com.example.webcrawler.components.linkextractor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class DefaultLinkExtractor implements LinkExtractor {

    private final String URL_MATCH_REGEX = "(www|http:|https:)+[\\w+|.|-|/]+";

    @Override
    public List<URL> extract(BufferedReader bufferedReader) throws IOException {
        List<URL> finalURLList = new ArrayList<>();
        while(true) {
            String line = bufferedReader.readLine();
            if(Objects.isNull(line)) {
                break;
            }
            Matcher matcher = getMatcher(line, URL_MATCH_REGEX);
            List<URL> urlList = extract(matcher);
            finalURLList.addAll(urlList);
        }

        return finalURLList;
    }

    private List<URL> extract(Matcher matcher) {
        List<URL> urlList = new ArrayList<>();

        while(matcher.find()) {
            String url = matcher.group();
            try {
                urlList.add(new URL(url));
            }
            catch (MalformedURLException exception) {
                log.info("Invalid URL : {}", url);
            }
        }
        return urlList;
    }

    private Matcher getMatcher(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text);
    }
}
