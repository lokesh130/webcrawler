package com.example.webcrawler.daos;

import com.example.webcrawler.entities.URLCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.net.URL;

@Repository
public interface URLCacheDAO extends JpaRepository<URLCache, Long> {
    public URLCache findByUrl(String url);
}
