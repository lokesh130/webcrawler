--liquibase formatted sql

--changeset lokesh.kumar2:1
CREATE TABLE url_cache (
    id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
    created_at   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    protocol VARCHAR(10) NOT NULL,
    url VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;