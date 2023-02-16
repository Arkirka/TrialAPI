INSERT INTO Users (id, name, password, email, create_date)
VALUES (1,'admin', 'admin', 'admin@example.com', '2020-01-01');
INSERT INTO Users (id, name, password, email, create_date)
VALUES (2,'Tom Riddle', 'goodGuy', 'avada.kedavra@dark.com', '2020-01-01');
INSERT INTO Users (id, name, password, email, create_date)
VALUES (3,'somewho', 'somewhat', 'some.email@somemail.com', '2020-01-01');

INSERT INTO Quotes (id, content, update_date, user_id)
VALUES (1,'This content is no longer available.', '2020-01-01', 1);
INSERT INTO Quotes (id, content, update_date, user_id)
VALUES (2,'Did you try to restart the PC?', '2020-01-01', 1);
INSERT INTO Quotes (id, content, update_date, user_id)
VALUES (3,'I am the administrator!', '2020-01-01', 1);

INSERT INTO Quotes (id, content, update_date, user_id)
VALUES (4,'I can make things move without touching them', '2020-01-01', 2);
INSERT INTO Quotes (id, content, update_date, user_id)
VALUES (5,'Surely you didn''t think I was going to keep my filthy Muggle father''s name? No.', '2020-01-01', 2);
INSERT INTO Quotes (id, content, update_date, user_id)
VALUES (6,'You have fought valiantly, but in vain.', '2020-01-01', 2);

INSERT INTO Quotes (id, content, update_date, user_id)
VALUES (7,'Something to say', '2020-01-01', 3);

INSERT INTO Votes (id, user_id, quote_id, is_like)
VALUES (1, 1, 7, 1);
INSERT INTO Votes (id, user_id, quote_id, is_like)
VALUES (2, 2, 7, 1);
INSERT INTO Votes (id, user_id, quote_id, is_like)
VALUES (3, 3, 7, 0);
INSERT INTO Votes (id, user_id, quote_id, is_like)
VALUES (4, 1, 2, 1);
INSERT INTO Votes (id, user_id, quote_id, is_like)
VALUES (5, 2, 2, 0);