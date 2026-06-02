/**
 * Author:  alexandre
 * Created: 30 de mai. de 2026
 */

CREATE TABLE IF NOT EXISTS person (
    id BIGINT AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);