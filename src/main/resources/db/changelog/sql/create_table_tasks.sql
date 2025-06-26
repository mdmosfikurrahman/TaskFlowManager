CREATE TABLE task
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    assigned_to_id BIGINT,
    project_id     BIGINT,
    CONSTRAINT fk_task_assigned_user FOREIGN KEY (assigned_to_id) REFERENCES user (id),
    CONSTRAINT fk_task_project FOREIGN KEY (project_id) REFERENCES project (id)
);
