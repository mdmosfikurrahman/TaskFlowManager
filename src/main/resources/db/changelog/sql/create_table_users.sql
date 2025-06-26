CREATE TABLE user
(
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    department_id BIGINT,
    CONSTRAINT fk_user_department FOREIGN KEY (department_id) REFERENCES department (id)
);
