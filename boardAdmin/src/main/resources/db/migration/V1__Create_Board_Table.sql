CREATE TABLE board (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    writer VARCHAR(255) NOT NULL,
    created_date TIMESTAMP,
    modified_date TIMESTAMP
);

