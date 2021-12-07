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
(1,6,5,4),
(2,1,1,1),
(3,1,1,2),
(4,1,1,3),
(5,1,1,4),
(6,1,2,1),
(7,1,2,2),
(8,1,2,3),
(9,1,2,4),
(10,1,3,1),
(11,1,3,2),
(12,1,3,3),
(13,1,3,4),
(14,1,4,1),
(15,1,4,2),
(16,1,4,3),
(17,1,4,4),
(18,1,5,1),
(19,1,5,2),
(20,1,5,3),
(21,1,5,4),
(22,2,1,1),
(23,2,1,2),
(24,2,1,3),
(25,2,1,4),
(26,2,2,1),
(27,2,2,2),
(28,2,2,3),
(29,2,2,4),
(30,2,3,1),
(31,2,3,2),
(32,2,3,3),
(33,2,3,4),
(34,2,4,1),
(35,2,4,2),
(36,2,4,3),
(37,2,4,4),
(38,2,5,1),
(39,2,5,2),
(40,2,5,3),
(41,2,5,4),
(42,3,1,1),
(43,3,1,2),
(44,3,1,3),
(45,3,1,4),
(46,3,2,1),
(47,3,2,2),
(48,3,2,3),
(49,3,2,4),
(50,3,3,1),
(51,3,3,2),
(52,3,3,3),
(53,3,3,4),
(54,3,4,1),
(55,3,4,2),
(56,3,4,3),
(57,3,4,4),
(58,3,5,1),
(59,3,5,2),
(60,3,5,3),
(61,3,5,4),
(62,4,1,1),
(63,4,1,2),
(64,4,1,3),
(65,4,1,4),
(66,4,2,1),
(67,4,2,2),
(68,4,2,3),
(69,4,2,4),
(70,4,3,1),
(71,4,3,2),
(72,4,3,3),
(73,4,3,4),
(74,4,4,1),
(75,4,4,2),
(76,4,4,3),
(77,4,4,4),
(78,4,5,1),
(79,4,5,2),
(80,4,5,3),
(81,4,5,4),
(82,5,1,1),
(83,5,1,2),
(84,5,1,3),
(85,5,1,4),
(86,5,2,1),
(87,5,2,2),
(88,5,2,3),
(89,5,2,4),
(90,5,3,1),
(91,5,3,2),
(92,5,3,3),
(93,5,3,4),
(94,5,4,1),
(95,5,4,2),
(96,5,4,3),
(97,5,4,4),
(98,5,5,1),
(99,5,5,2),
(100,5,5,3),
(101,5,5,4),
(102,6,1,1),
(103,6,1,2),
(104,6,1,3),
(105,6,1,4),
(106,6,2,1),
(107,6,2,2),
(108,6,2,3),
(109,6,2,4),
(110,6,3,1),
(111,6,3,2),
(112,6,3,3),
(113,6,3,4),
(114,6,4,1),
(115,6,4,2),
(116,6,4,3),
(117,6,4,4),
(118,6,5,1),
(119,6,5,2),
(120,6,5,3);

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

DROP TABLE IF EXISTS MOVIECREDIT;
CREATE TABLE MOVIECREDIT (
	MovieCreditID INTEGER NOT NULL AUTO_INCREMENT,
    Email VARCHAR(100),
    Amount DOUBLE,
    primary key (MovieCreditID)
);

INSERT INTO MOVIECREDIT (Email, Amount) VALUES
('g@gmail.com', 15.00),
('goodbye@gmail.com', 20.00),
('goodbye@gmail.com', 17.00),
('hello@gmail.com', 8.50),
('hello@gmail.com', 17.00),
('welcome@gmail.com', 8.50);

DROP TABLE IF EXISTS ANNOUNCEMENTS;
CREATE TABLE ANNOUNCEMENTS (
	AnnouncementId integer,
    Announcement varchar(100),
	PRIMARY KEY(AnnouncementId)
);

INSERT INTO ANNOUNCEMENTS(AnnouncementId, Announcement) VALUES
(1, 'New movie Starwars in theatres 12-12-21 on Presale NOW for 10% of reserved seats!'),
(2, 'New movie Juno in theatres 12-15-21 on Presale NOW for 10% of reserved seats!'),
(3, 'New movie Avatar in theatres 12-17-21 on Presale NOW for 10% of reserved seats'),
(4, 'New movie Star in theatres 12-19-21 on Presale NOW for 10% of reserved seats'),
(5, 'New movie wars in theatres 12-12-21 on Presale NOW for 10% of reserved seats!'),
(6, 'New movie Hairspray in theatres 12-15-21 on Presale NOW for 10% of reserved seats!'),
(7, 'New movie harry potter in theatres 12-17-21 on Presale NOW for 10% of reserved seats'),
(8, 'New movie home alone in theatres 12-19-21 on Presale NOW for 10% of reserved seats');

