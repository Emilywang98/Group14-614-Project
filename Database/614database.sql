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
('Jintao97','123458','Jintao', 'Wang','2500 University Dr NW, Calgary, AB T2N 1N4','jintaoWang@gmail.com','4485144470717028','905','1227'),
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
    ShowDate Date,
    ShowTime time,
    price integer,
    primary key (ShowTimeID),
    foreign key (MovieName) references MOVIES(Name),
    foreign key (TheatreName) references THEATRES(Name)
);
INSERT INTO SHOWTIME (ShowTimeID, MovieName, TheatreName, ShowDate, ShowTime, price)
VALUES
(1, "No Time To Die", "Ciniplex Chinook", '2021-12-01', '10:00', 15),
(2, "No Time To Die", "Ciniplex Chinook", '2021-12-01', '12:00', 15),
(3, "Dune", "Ciniplex Crowfoot", '2021-12-01', '14:00', 20),
(4, "Dune", "Ciniplex Crowfoot", '2021-12-01', '16:00', 20),
(5, "Spider-Man: No Way Home", "Ciniplex Sunridge", '2021-12-01', '18:00', 25),
(6, "Spider-Man: No Way Home", "Ciniplex Sunridge", '2021-12-01', '20:00', 25);

DROP TABLE IF EXISTS SEAT;
CREATE TABLE Seat (
	SeatID integer NOT NULL auto_increment,
    ShowtimeID integer,
    SeatRow integer,
    SeatColumn integer,
	primary key (SeatID),
    foreign key (ShowTimeID) references SHOWTIME(ShowTimeID)
);

INSERT INTO Seat (SeatID, ShowtimeID, SeatRow, SeatColumn) VALUES
(1,1,1,1),
(2,1,1,2),
(3,1,1,3),
(4,1,2,1),
(5,1,2,2),
(6,1,2,3),
(7,1,3,1),
(8,1,3,2),
(9,1,3,3),
(10,2,1,1),
(11,2,1,2),
(12,2,1,3),
(13,2,2,1),
(14,2,2,2),
(15,2,2,3),
(16,2,3,1),
(17,2,3,2),
(18,2,3,3),
(19,3,1,1),
(20,3,1,2),
(21,3,1,3),
(22,3,2,1),
(23,3,2,2),
(24,3,2,3),
(25,3,3,1),
(26,3,3,2),
(27,3,3,3),
(28,4,1,1),
(29,4,1,2),
(30,4,1,3),
(31,4,2,1),
(32,4,2,2),
(33,4,2,3),
(34,4,3,1),
(35,4,3,2),
(36,4,3,3),
(37,5,1,1),
(38,5,1,2),
(39,5,1,3),
(40,5,2,1),
(41,5,2,2),
(42,5,2,3),
(43,5,3,1),
(44,5,3,2),
(45,5,3,3),
(46,6,1,1),
(47,6,1,2),
(48,6,1,3),
(49,6,2,1),
(50,6,2,2),
(51,6,2,3),
(52,6,3,1),
(53,6,3,2),
(54,6,3,3),
(55,1,4,2),
(56,2,4,2),
(57,3,4,2),
(58,4,4,2),
(59,5,4,2),
(60,6,4,2);

DROP TABLE IF EXISTS TICKET;
CREATE TABLE TICKET (
	TicketID INTEGER NOT NULL AUTO_INCREMENT,
    SeatID integer,
    `Status` VARCHAR(100),
    Email VARCHAR(100),
    primary key (TicketID),
    foreign key (SeatID) references SEAT(SeatID)
);

INSERT INTO TICKET (SeatID, `Status`, Email) VALUES
(1, "reserved", 'hello@gmail.com'),
(2, "paid", 'hello@gmail.com'),
(3, "reserved", 'goodbye@gmail.com'),
(4, "reserved", 'goodbye@gmail.com'),
(5, "reserved", 'goodbye@gmail.com'),
(6, "paid", 'hello@gmail.com'),
(7, "paid", 'welcome@gmail.com'),
(8, "paid", 'welcome@gmail.com'),
(9, "paid", 'welcome@gmail.com');
