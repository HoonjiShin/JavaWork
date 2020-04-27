
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;

/* Create Tables */

CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);

--시퀀스 객체 생성
DROP SEQUENCE phonebook_seq;
CREATE SEQUENCE phonebook_seq;

SELECT * FROM PHONEBOOK ORDER BY pb_uid desc;

SELECT COUNT(*) CNT FROM TEST_MEMBER; --테이블의 모든 레코드 갯수
SELECT MAX(MB_NO) "MAX" FROM TEST_MEMBER;
SELECT MIN(MB_NO) "MIN" FROM TEST_MEMBER;

SELECT * FROM PHONEBOOK;