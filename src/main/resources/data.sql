INSERT INTO floor(id, floor_number)
VALUES (1, 1);
INSERT INTO floor(id, floor_number)
VALUES (2, 2);

INSERT INTO room(id, name, floor, capacity, video_conference, drawing_board)
VALUES (10, 'Grand', 1, 12, true, true);
INSERT INTO room(id, name, floor, capacity, video_conference, drawing_board)
VALUES (11, 'Piano', 1, 4, true, false);

INSERT INTO room(id, name, floor, capacity, video_conference, drawing_board)
VALUES (20, 'Cozy', 2, 2, false, false);
INSERT INTO room(id, name, floor, capacity, video_conference, drawing_board)
VALUES (21, 'Business', 2, 22, true, true);

INSERT INTO team(id, name)
VALUES (1, 'Avengers');
INSERT INTO team(id, name)
VALUES (2, 'Guardians of the Galaxy');

INSERT INTO employee (id, username, team)
VALUES (1, 'ironman', 1);
INSERT INTO employee (id, username, team)
VALUES (2, 'spiderman', 1);

INSERT INTO employee (id, username, team)
VALUES (3, 'starlord', 2);
INSERT INTO employee (id, username, team)
VALUES (4, 'drax', 2);

INSERT INTO reservation(room, employee, reserved_from, reserved_to, confirmed_arrival, active)
VALUES (10, 1, '2021-01-11 12:00:00-00', '2021-01-11 13:00:00-00', true, true);
INSERT INTO reservation(room, employee, reserved_from, reserved_to, confirmed_arrival, active)
VALUES (20, 4, '2021-10-05 14:30:00-00', '2021-10-05 15:00:00-00', false, true);