--liquibase formatted sql
--changeset kpawelec:1
CREATE TABLE category (
                       id SERIAL PRIMARY KEY,
                       name TEXT NOT NULL,
                       description TEXT NOT NULL,
                       slug TEXT NOT NULL
);
