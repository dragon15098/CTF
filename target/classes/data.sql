INSERT INTO ROLE VALUES (1, 'ADMIN'), (2, 'USER'), (3, 'GOD');
INSERT INTO USER VALUES (1,1, 'god@gmail.com', 'God', 'God', '$2a$10$FPJCQE1u7EvkgKyet5.7n.juIBzPFcGm3pmnE.UiTTnk1E8VHvK6S');
INSERT INTO USER VALUES (2,1, 'admin@gmail.com', 'Admin', 'Admin', '$2a$10$FPJCQE1u7EvkgKyet5.7n.juIBzPFcGm3pmnE.UiTTnk1E8VHvK6S');
INSERT INTO USER_ROLE VALUES (1,3);
INSERT INTO USER_ROLE VALUES (2,1);
INSERT INTO ROOM VALUES (1, 1, 'SUPER-VIP-ROOM', 1);
INSERT INTO USER_ROOM VALUES (1, 1, 1);
INSERT INTO USER_ROOM VALUES (2, 1, 2);
INSERT INTO MESSAGE VALUES (1, 'God give you this src: /super_secret_src_zzzzzzzz.zip', '[{"@type":"com.myjavablog.model.TextColor","value":"#000000"},{"@type":"com.myjavablog.model.TextStyle","value":"bold"}]', 1);
INSERT INTO ROOM_MESSAGE VALUES (1, 1, 1);