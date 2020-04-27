SELECT * FROM t_professor;

-- null 값 과의 연산 결과는 null 이다!
SELECT name, pay, bonus, pay + bonus
FROM t_professor;

--그룹함수에서는 동작, null은 연산에서 제외되어 동작
SELECT SUM(PAY), sum(BONUS) FROM T_PROFESSOR;

--nvl()
SELECT name, pay, bonus, pay + bonus,PAY+NVL(BONUS ,0) 총지급액
FROM t_professor;

--#4201
SELECT NAME ,PAY ,NVL(BONUS ,0) BONUS ,PAY *12 + NVL(BONUS ,0) 연봉 FROM T_PROFESSOR WHERE DEPTNO =101;
SELECT name, pay, nvl2(bonus, bonus, 0) BONUS, 
	nvl2(bonus, pay * 12 + bonus,  pay * 12) 연봉 FROM T_PROFESSOR WHERE DEPTNO = 101;