INSERT INTO users (username, email, password, created_at) VALUES
('admin', 'admin@example.com', '$2a$12$X5r4wTbQW6zL5YXxYxYxYxYxYxYxYxYxYxYxYxYxYxYxYxYxYxYxY','20241209');

INSERT INTO roles (name) VALUES
('ROLE_ADMIN'),
('ROLE_REVISOR'),
('ROLE_WRITER'),
('ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES
(1, 1);

INSERT INTO categories (name) VALUES
('Politica'),
('Economia'),
('Food & Drink'),
('Sport'),
('Intrattenimento'),
('Tech');