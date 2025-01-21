--liquibase formatted sql
--changeset kpawelec:4


CREATE TABLE event_occurrence (
                                  id SERIAL PRIMARY KEY,
                                  event_id INTEGER NOT NULL,
                                  date DATE NOT NULL,
                                  time TIME NOT NULL,
                                  is_common_pool BOOLEAN NOT NULL
);
