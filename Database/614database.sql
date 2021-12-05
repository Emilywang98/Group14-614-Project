DROP DATABASE IF EXISTS MOVIETHEATRE;
CREATE DATABASE MOVIETHEATRE;
USE MOVIETHEATRE;

DROP TABLE IF EXISTS REGISTEREDUSER;
CREATE TABLE REGISTEREDUSER (
  Username				varchar(100) NOT NULL,
  Password				varchar(100) NOT NULL,
  FName					varchar(100),
  LName					varchar(100),
  Address		        varchar(100),
  Email					varchar(100),
  Card_no			    varchar(100),
  Card_cvv				varchar(100),
  Card_exp				varchar(100),
  PRIMARY key (Username)
);
INSERT INTO REGISTEREDUSER VALUES
('Erika97','123456','Erika', 'Wang','2500 University Dr NW, Calgary, AB T2N 1N4','erikawang97@gmail.com','4485144470717028','905','1225'),
('Jintao96','123458','Jintao', 'Wang','2500 University Dr NW, Calgary, AB T2N 1N4','jintaoWang@gmail.com','4485144470717028','905','1227'),
('Emily98','123459','Emily', 'Wang','2500 University Dr NW, Calgary, AB T2N 1N4','emilyWang@gmail.com','4485144470717028','905','1229'),
('greg96','123457','Gregory', 'Slowski','2500 University Dr NW, Calgary, AB T2N 1N4','gslowski@gmail.com','91238649823','906','1226');

DROP TABLE IF EXISTS THEATRES;
CREATE TABLE THEATRES (
	Name varchar(50) not null,
    primary key (Name)
);
INSERT INTO THEATRES VALUES
('Ciniplex Chinook'),
('Ciniplex Crowfoot'),
('Ciniplex Sunridge');


DROP TABLE IF EXISTS MOVIES;
CREATE TABLE MOVIES (
	Name varchar(30) not null,
    primary key (Name)
);

INSERT INTO MOVIES VALUES
('No Time To Die'),
('Dune'),
('Spider-Man: No Way Home');

DROP TABLE IF EXISTS SHOWTIME;
CREATE TABLE SHOWTIME (
	ShowTimeID integer not null,
	MovieName varchar(50) not null,
    TheatreName varchar(50) not null,
    TheatreRoomNumber integer, 
    ShowDate Date,
    ShowTime time,
    price integer,
    primary key (ShowTimeID),
    foreign key (MovieName) references MOVIES(Name),
    foreign key (TheatreName) references THEATRES(Name)
);
INSERT INTO SHOWTIME (ShowTimeID, MovieName, TheatreName, TheatreRoomNumber, ShowDate, ShowTime, price)
VALUES
(1, "No Time To Die", "Ciniplex Chinook", 1, '2021-12-01', '10:00', 15),
(2, "No Time To Die", "Ciniplex Chinook", 1, '2021-12-01', '12:00', 15),
(3, "Dune", "Ciniplex Crowfoot", 1, '2021-12-01', '14:00', 20),
(4, "Dune", "Ciniplex Crowfoot", 1, '2021-12-01', '16:00', 20),
(5, "Spider-Man: No Way Home", "Ciniplex Sunridge", 1, '2021-12-01', '18:00', 25);

DROP TABLE IF EXISTS SEAT;
CREATE TABLE Seat (
	SeatID integer,
    SeatRow integer,
    SeatColumn integer,
	primary key (SeatID)
);

INSERT INTO Seat (SeatID, SeatRow, SeatColumn) VALUES
(1,7,7),
(2,7,8),
(3,7,9),
(4,8,7),
(5,8,8),
(6,8,9),
(7,9,7),
(8,9,8),
(9,9,9);

DROP TABLE IF EXISTS TICKET;
CREATE TABLE TICKET (
	TicketID integer,
    ShowTimeID integer,
    SeatID integer,
    `Status` VARCHAR(100),
    Email VARCHAR(100),
    foreign key (ShowTimeID) references SHOWTIME(ShowTimeID),
    foreign key (SeatID) references SEAT(SeatID)
);

INSERT INTO TICKET (TicketID, ShowTimeID, SeatID, `Status`, Email) VALUES
(1,1,1, "reserved", 'hello@gmail.com'),
(2,1,2, "paid", 'hello1@gmail.com'),
(3,2,3, "reserved", 'hello2@gmail.com'),
(4,3,4, "reserved", 'hello3@gmail.com'),
(5,4,5, "reserved", 'hello4@gmail.com'),
(6,5,6, "paid", 'hello5@gmail.com');
