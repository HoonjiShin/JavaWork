
/* Drop Tables */

DROP TABLE practice_write CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE practice_write
(
	pr_uid number NOT NULL,
	pr_subject varchar2(100) NOT NULL,
	pr_content clob,
	pr_name varchar2(20) NOT NULL,
	pr_viewcnt number DEFAULT 0,
	pr_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pr_uid)
);

CREATE SEQUENCE PRACTICE_WRITE_SEQ;

INSERT INTO PRACTICE_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '첫째글:방가요', '안녕하세요', '김희철', 0, '2017-03-02');
INSERT INTO PRACTICE_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '둘째글:헤헤헤','1111', '김수길', 0, '2017-03-02');
INSERT INTO PRACTICE_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '세째글:힘내세요', '7394', '최진덕' , 0, '2017-08-12');
INSERT INTO PRACTICE_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '네째글: ... ', '9090', '이혜원', 0, '2018-02-09');
INSERT INTO PRACTICE_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '다섯째글: 게시판', '7531', '박수찬', 0, sysdate);


SELECT * FROM PRACTICE_WRITE;