CREATE SEQUENCE news_record_seq;

CREATE TABLE news_record
(
    id          BIGINT PRIMARY KEY,
    title       VARCHAR(150) NOT NULL,
    description TEXT
);