
/* Drop Tables */


DROP TABLE test_card CASCADE CONSTRAINTS;
DROP TABLE test_ticket CASCADE CONSTRAINTS;



CREATE TABLE test_card
(
	user_id varchar2(20) NOT NULL,
	buy_amount number DEFAULT 1
);


CREATE TABLE test_ticket
(
	user_id varchar2(20) NOT NULL,
	ticket_count number
);

SELECT * FROM TEST_TICKET;


