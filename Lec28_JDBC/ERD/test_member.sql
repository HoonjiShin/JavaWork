
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;




DELETE FROM test_member;

--시퀀스
DROP SEQUENCE test_member_seq;
CREATE SEQUENCE test_member_seq;

SELECT * FROM TEST_MEMBER ORDER BY mb_no DESC;