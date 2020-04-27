
/* Drop Tables */

DROP TABLE Inclass CASCADE CONSTRAINTS;
DROP TABLE subject CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE major CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE Inclass
(
	studno number NOT NULL,
	subjno number NOT NULL
);


CREATE TABLE major
(
	majorno number NOT NULL,
	majorphone varchar2(20),
	office varchar2(20),
	majorname varchar2(20) NOT NULL,
	PRIMARY KEY (majorno)
);


CREATE TABLE professor
(
	profno number NOT NULL,
	profname varchar2(10) NOT NULL,
	profjumin varchar2(20),
	profaddress varchar2(40),
	hireyear varchar2(10),
	profphone varchar2(20),
	profstatus varchar2(10),
	majorno number NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE student
(
	studno number NOT NULL,
	name varchar2(10) NOT NULL,
	grade number,
	jumin varchar2(20),
	phonenum varchar2(15),
	address varchar2(40),
	majorno number NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE subject
(
	subjno number NOT NULL,
	subjname varchar2(10),
	score number,
	studcount number,
	class varchar2(15),
	classyear varchar2(5),
	profno number NOT NULL,
	PRIMARY KEY (subjno)
);



/* Create Foreign Keys */

ALTER TABLE professor
	ADD FOREIGN KEY (majorno)
	REFERENCES major (majorno)
;


ALTER TABLE student
	ADD FOREIGN KEY (majorno)
	REFERENCES major (majorno)
;


ALTER TABLE subject
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE Inclass
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;


ALTER TABLE Inclass
	ADD FOREIGN KEY (subjno)
	REFERENCES subject (subjno)
;



