package com.example.webcrawler.entities;

import com.example.webcrawler.entities.enums.URLProtocol;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Table(name = "url_cache")
@Entity
@Builder
@NamedQueries(value = {
        @NamedQuery(name = "get.by.url",
                query = "SELECT U from URLCache U where U.url = :url ")
})
public class URLCache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "protocol")
    private URLProtocol protocol;

    @Column(name = "url")
    private String url;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}


