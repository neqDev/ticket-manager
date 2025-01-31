--liquibase formatted sql
--changeset kpawelec:7
-- Utworzenie tabeli images
CREATE TABLE image (
                       id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       description VARCHAR(255),
                       thumb_image VARCHAR(255)
);

-- Dodanie kolumny image_id do tabeli event
ALTER TABLE event
    ADD COLUMN image_id BIGINT;

-- Dodanie klucza obcego do tabeli event dla relacji wiele-do-jednego z tabelą image
ALTER TABLE event
    ADD CONSTRAINT fk_event_image
        FOREIGN KEY (image_id) REFERENCES image (id) ON DELETE SET NULL;
