# Init roles
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_MODERATOR');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

# Init users
INSERT INTO users (email, password, username) VALUES ('chieesnddafo@gmail.com', '$2a$10$iCDLUsBEpOkLhq2iSrgdceAcNru1C/LMJ5eBVYEUATP.OAZTgucje', 'chieesnddafo');

# Init user_roles
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);

# Init tutorials
INSERT INTO tutorials (content, expected, title) VALUES ('CONTENT1', 'EXPECTED1', 'TITLE1');

# Init solutions
INSERT INTO solutions (created_at, details, tutorial_id, user_id) VALUES ('2022-04-24 10:22:28', 'DETAILS1', 1, 1);
INSERT INTO solutions (created_at, details, tutorial_id, user_id) VALUES ('2022-04-24 10:48:32', null, 1, 1);
INSERT INTO solutions (created_at, details, tutorial_id, user_id) VALUES ('2022-04-24 10:49:08', 'solution1', 1, 1);
