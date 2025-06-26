CREATE TABLE project
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    manager_id BIGINT,
    CONSTRAINT fk_project_manager FOREIGN KEY (manager_id) REFERENCES user (id)
);
