--liquibase formatted sql
--changeset kpawelec:6
-- Utworzenie tabeli ticket
CREATE TABLE concrete_ticket (
                        id SERIAL PRIMARY KEY,
                        general_ticket_id INTEGER NOT NULL,
                        qr_code BYTEA,
                        is_used bool default false,
                        FOREIGN KEY (general_ticket_id) REFERENCES ticket(id) ON DELETE CASCADE
);
