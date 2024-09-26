-- Rename the 'cityId' column to 'city_id' to match the entity mapping
ALTER TABLE airport CHANGE cityId city_id BIGINT NOT NULL;
