-- =========================
-- REGION
-- =========================
INSERT INTO region (id_region, name) VALUES
(1, 'Cataluña'),
(2, 'Comunidad Valenciana'),
(3, 'Madrid'),
(4, 'Andalucía');

-- =========================
-- COMUNITY
-- =========================
INSERT INTO comunity (id_comunity, id_region, name) VALUES
(1, 1, 'Tarragona'),
(2, 1, 'Barcelona'),
(3, 2, 'Valencia'),
(4, 3, 'Madrid');

-- =========================
-- PROVINCE
-- =========================
INSERT INTO province (id_comunity, id_province, name) VALUES
(1, 1, 'Tarragona'),
(2, 2, 'Barcelona'),
(3, 3, 'Valencia'),
(4, 4, 'Madrid');

-- =========================
-- CITY
-- =========================
INSERT INTO city (ine, id_city, id_province, name) VALUES
('43148', 1, 1, 'Tarragona'),
('08019', 2, 2, 'Barcelona'),
('46250', 3, 3, 'Valencia'),
('28079', 4, 4, 'Madrid'),
('41091', 5, 4, 'Sevilla');

-- =========================
-- LOCATION
-- =========================
INSERT INTO location (id_location, postal_code, id_city, name) VALUES
(1, '43001', 1, 'Centro Tarragona'),
(2, '08001', 2, 'Centro Barcelona'),
(3, '46001', 3, 'Centro Valencia'),
(4, '28001', 4, 'Centro Madrid'),
(5, '41001', 5, 'Centro Sevilla');

-- =========================
-- CENTER_TYPE
-- =========================
INSERT INTO center_type (id_type, name) VALUES
(1, 'Hospital'),
(2, 'Clínica'),
(3, 'Centro de Día'),
(4, 'Residencia'),
(5, 'Rehabilitación');

-- =========================
-- CENTER
-- =========================
INSERT INTO center (id_center, id_location, id_type, created_at, updated_at, address, description, name) VALUES
(1, 1, 1, NOW(), NOW(), 'Calle Mayor 1', 'Hospital público', 'Hospital Tarragona'),
(2, 2, 2, NOW(), NOW(), 'Av. Diagonal 123', 'Clínica privada', 'Clínica Barcelona'),
(3, 3, 3, NOW(), NOW(), 'Calle Colón 45', 'Centro de día', 'Centro Valencia'),
(4, 4, 4, NOW(), NOW(), 'Gran Vía 10', 'Residencia mayores', 'Residencia Madrid'),
(5, 5, 5, NOW(), NOW(), 'Av. Andalucía 22', 'Centro rehabilitación', 'Rehab Sevilla');

-- =========================
-- CENTER_CHARACTERISTIC
-- =========================
INSERT INTO center_characteristic (id, id_center, name) VALUES
(1, 1, 'Urgencias 24h'),
(2, 2, 'Atención personalizada'),
(3, 3, 'Actividades diarias'),
(4, 4, 'Habitaciones privadas'),
(5, 5, 'Fisioterapia avanzada');

-- =========================
-- SOCIAL
-- =========================
INSERT INTO social (id_social, img_url, name) VALUES
(1, 'facebook.png', 'Facebook'),
(2, 'twitter.png', 'Twitter'),
(3, 'instagram.png', 'Instagram'),
(4, 'linkedin.png', 'LinkedIn');

-- =========================
-- CENTER_SOCIAL
-- =========================
INSERT INTO center_social (id_center, id_social, link) VALUES
(1, 1, 'https://facebook.com/hospitaltarragona'),
(2, 2, 'https://twitter.com/clinicabarcelona'),
(3, 3, 'https://instagram.com/centrovalencia'),
(4, 4, 'https://linkedin.com/residenciamadrid'),
(5, 1, 'https://facebook.com/rehabsevilla');

-- =========================
-- PHONE
-- =========================
INSERT INTO phone (id, id_center, phone) VALUES
(1, 1, '977000111'),
(2, 2, '933000222'),
(3, 3, '963000333'),
(4, 4, '913000444'),
(5, 5, '954000555');

-- =========================
-- USER_ROLE
-- =========================
INSERT INTO user_role (id_role, name) VALUES
(1, 'Admin'),
(2, 'Gestor'),
(3, 'Usuario'),
(4, 'Invitado');

-- =========================
-- USERS
-- =========================
INSERT INTO users (id_user, id_role, created_at, updated_at, email, password_hashed, username) VALUES
(1, 1, NOW(), NOW(), 'admin@remmy.com', 'hash_admin', 'admin'),
(2, 2, NOW(), NOW(), 'gestor@remmy.com', 'hash_gestor', 'gestor'),
(3, 3, NOW(), NOW(), 'user1@remmy.com', 'hash_user1', 'user1'),
(4, 3, NOW(), NOW(), 'user2@remmy.com', 'hash_user2', 'user2'),
(5, 4, NOW(), NOW(), 'guest@remmy.com', 'hash_guest', 'guest');