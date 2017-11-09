INSERT INTO app_role (id, role_name, description) VALUES (1, 'ROLE_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ROLE_ADMIN', 'Admin User - Has permission to perform admin tasks');
INSERT INTO app_role (id, role_name, description) VALUES (3, 'ROLE_MODERATOR', 'DESC');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'TOGRUL', 'AGAYEV', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'togrul');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'ARAZ', 'VALIZADA', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'araz');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (3, 'TOGRUL', 'RAHIMLI', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'togrulr');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (4, 'SEYMUR', 'ASADOV', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'seymur');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (5, 'TALEH', 'ALQAYEV', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'taleh');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(5,1);
INSERT INTO user_role(user_id, role_id) VALUES(5,2);
INSERT INTO user_role(user_id, role_id) VALUES(5,3);
INSERT INTO user_role(user_id, role_id) VALUES(4,2);
INSERT INTO user_role(user_id, role_id) VALUES(4,3);

-- Populate random city table

INSERT INTO random_city(id, name) VALUES (1, 'Baku');
INSERT INTO random_city(id, name) VALUES (2, 'Belokan');
INSERT INTO random_city(id, name) VALUES (3, 'Barda');
INSERT INTO random_city(id, name) VALUES (4, 'Ganca');
INSERT INTO random_city(id, name) VALUES (5, 'Shaki');
INSERT INTO random_city(id, name) VALUES (6, 'Zaqatala');
INSERT INTO random_city(id, name) VALUES (7, 'Lankaran');
INSERT INTO random_city(id, name) VALUES (8, 'Culfa');
