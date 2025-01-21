--liquibase formatted sql
--changeset kpawelec:1
CREATE TABLE cart (
                       id SERIAL PRIMARY KEY,
                       created date NOT NULL
);
