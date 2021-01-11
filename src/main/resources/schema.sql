-- Floor --
CREATE SEQUENCE floor_sequence
    START WITH 100000
    INCREMENT BY 1
    MINVALUE 1;

CREATE TABLE floor
(
    id          INTEGER DEFAULT nextval('floor_sequence'),
    floorNumber integer NOT NULL,
    PRIMARY KEY (id)
);

-- Room --
CREATE SEQUENCE room_sequence
    START WITH 100000
    INCREMENT BY 1
    MINVALUE 1;

CREATE TABLE room
(
    id              INTEGER DEFAULT nextval('room_sequence'),
    name            varchar NOT NULL,
    floor           INTEGER NOT NULL REFERENCES floor,
    capacity        INT4    NOT NULL,
    videoConference BOOLEAN NOT NULL,
    drawingBoard    BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

-- Team --
CREATE SEQUENCE team_sequence
    START WITH 100000
    INCREMENT BY 1
    MINVALUE 1;

CREATE TABLE team
(
    id   INTEGER DEFAULT nextval('team_sequence'),
    name varchar NOT NULL,
    PRIMARY KEY (id)
);

-- Emploee --
CREATE SEQUENCE employee_sequence
    START WITH 100000
    INCREMENT BY 1
    MINVALUE 1;

CREATE TABLE employee
(
    id       INTEGER DEFAULT nextval('employee_sequence'),
    username varchar NOT NULL,
    team     INTEGER NOT NULL REFERENCES team,
    PRIMARY KEY (id)
);

-- Reservation --
CREATE SEQUENCE reservation_sequence
    START WITH 100000
    INCREMENT BY 1
    MINVALUE 1;

CREATE TABLE reservation
(
    id               INTEGER DEFAULT nextval('reservation_sequence'),
    room             INTEGER   NOT NULL REFERENCES room,
    employee         INTEGER   NOT NULL REFERENCES employee,
    reservedFrom     TIMESTAMP NOT NULL,
    reservedTo       TIMESTAMP NOT NULL,
    confirmedArrival BOOLEAN   NOT NULL,
    active           BOOLEAN   NOT NULL,
    PRIMARY KEY (id)
);
