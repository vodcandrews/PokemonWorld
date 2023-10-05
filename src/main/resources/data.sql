CREATE TABLE IF NOT EXISTS pokemon (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    height DECIMAL(5, 2),
    weakness VARCHAR(255),
    type VARCHAR(255), -- Use VARCHAR for the type field
    ability VARCHAR(255)
    );

INSERT INTO pokemon (name, height, weakness, type,  ability)
VALUES ('Pikachu', 40.6, 'Ground', 'ELECTRIC', 'Static');

INSERT INTO pokemon (name, height, weakness, type, ability)
VALUES ('Eevee', 30.5, 'Fighting', 'ELECTRIC', 'Adaptability');
