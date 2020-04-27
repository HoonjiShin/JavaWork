----------------------------------------
-- Sub Query

-- #7101
--t_emp 테이블에서 
-- scott 보다 급여를 많이 받는 사람의 이름과 급여 출력
SELECT * FROM T_EMP;

SELECT SAL FROM T_EMP WHERE ENAME = 'SCOTT';

SELECT ENAME,SAL FROM T_EMP 
WHERE SAL > (SELECT SAL FROM T_EMP WHERE ENAME = 'SCOTT');

-- #7102
-- t_student 테이블에서 가장 키 큰 학생의 '이름'과 '키'를 출력

SELECT MAX(HEIGHT) FROM T_STUDENT;

SELECT NAME ,HEIGHT FROM T_STUDENT 
WHERE HEIGHT = (SELECT MAX(HEIGHT) FROM T_STUDENT);

-- 1. 단일행 서브 쿼리

--#7103)연습
--t_student, t_department 테이블 사용하여 
--이윤나 학생과 1전공(deptno1)이 동일한 학생들의 
--이름(name)과 1전공이름(dname)을 출력하세요

SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나';

SELECT s.NAME ,d.DNAME FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO1 = d.DEPTNO AND s.DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나');


-- #7104) 연습
--t_professor, t_department 테이블 : 입사일이 송도권 교수보다 나중에 입사한 사람의 
--이름과 입사일, 학과명을 출력하세요

SELECT p.NAME 교수명, TO_CHAR(p.HIREDATE,'YYYY-MM-DD') 입사일, d.DNAME 학과명 
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.HIREDATE > (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '송도권' );


-- #7105) 연습
--t_student 테이블 :  1전공이 101번인 학과의 평균 몸무게보다 몸무게가 많은 학생들의 
--이름과 몸무게를 출력하세요

SELECT NAME 이름, WEIGHT 몸무게 FROM T_STUDENT 
WHERE WEIGHT > (SELECT AVG(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 = 101)

--#7106) 연습
--t_professor 테이블에서 심슨 교수와 같은 입사일에 입사한 교수 중, 
--조인형 교수보다 월급을 적게 받는 교수의  이름과 급여, 입사일을 출력하세요

SELECT NAME 이름, PAY 급여, TO_CHAR(HIREDATE,'YY/MM/DD') 입사일 FROM T_PROFESSOR 
WHERE PAY < (SELECT PAY FROM T_PROFESSOR WHERE NAME = '조인형')
AND HIREDATE = (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME ='심슨'); 

-- 2. 다중행 쿼리
-- Sub Query 결과가 2건 이상 출력되는 것을 말합니다.
-- 다중행 Sub Query 와 함께 사용하는 연산자
--		 IN 같은 값을 찾음
--		>ANY 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 큰)
--		<ANY 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 작은)
--		<ALL 최소값을 반환함 (서브쿼리 결과중 가장작은것보다 작은)
--		>ALL 최대값을 반환함 (서브쿼리 결과중 가장큰것보다 큰)
--		EXIST Sub Query 값이 있을 경우 반환

-- #7107
--t_emp2, dept2 테이블 : 
--근무지역 (t_dept2.area) 이 서울 지사인 모든 사원들의 
--사번(empno)과 이름(name), 부서번호(deptno)를 출력하세요
SELECT * FROM t_emp2;
SELECT * FROM T_DEPT2; 

SELECT dcode FROM t_dept2 WHERE area = '서울지사';

SELECT empno, name, deptno
FROM t_emp2
WHERE deptno IN (SELECT dcode FROM t_dept2 WHERE area = '서울지사')
;

--#7108) 연습
--t_emp2 테이블 : 
--전체직원중 과장 직급의 최소연봉자보다 
--연봉이 높은 사람의 
--이름(name)과 직급(post), 연봉(pay)을 출력하세요.  
--단, 연봉 출력 형식은 천 단위 구분 기호와 원 표시를 하세요
SELECT NAME , POST , PAY 
FROM T_EMP2
WHERE PAY > ANY (SELECT PAY FROM T_EMP2 WHERE POST = '과장');

--#7109) 연습
--t_student 테이블 : 
--전체학생중에서 체중이 4학년 학생들의 체중에서 
--가장 적게 나가는 학생보다 
--몸무게가 적은 학생의 이름과 학년과 몸무게를 출력하세요

SELECT WEIGHT FROM T_STUDENT WHERE GRADE = 4;

SELECT NAME 이름, GRADE 학년, WEIGHT 몸무게 
FROM T_STUDENT
WHERE WEIGHT < ALL(SELECT WEIGHT FROM T_STUDENT WHERE GRADE = 4);

SELECT GRADE ,MAX(HEIGHT) 
FROM T_STUDENT GROUP BY GRADE


SELECT GRADE 학년, NAME 이름, HEIGHT 키 FROM T_STUDENT
WHERE(GRADE,HEIGHT)IN(SELECT GRADE ,MAX(HEIGHT) 
FROM T_STUDENT GROUP BY GRADE) 
ORDER BY GRADE ASC;

SELECT p.DEPTNO, TO_CHAR(MIN(p.HIREDATE),'YYYY-MM-DD') 
FROM T_PROFESSOR p, T_DEPARTMENT d
GROUP BY p.DEPTNO ;

--#7204
SELECT P.PROFNO 교수번호, P.NAME 교수명, 
	   TO_CHAR(P.HIREDATE,'YYYY-MM-DD') 입사일 , D.DNAME 학과명 
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE p.DEPTNO = d.DEPTNO 
AND (P.DEPTNO,P.HIREDATE) 
IN (SELECT p.DEPTNO, TO_CHAR(MIN(p.HIREDATE),'YYYY-MM-DD') 
FROM T_PROFESSOR p, T_DEPARTMENT d
GROUP BY p.DEPTNO)
ORDER BY D.DNAME ;

--#7203
SELECT POST, MAX(PAY) 
FROM T_EMP2 GROUP BY POST;

SELECT NAME 사원명, POST 직급, PAY 연봉 
FROM T_EMP2 WHERE (POST,PAY) IN (SELECT POST, MAX(PAY) 
FROM T_EMP2 GROUP BY POST)
ORDER BY PAY ;

--#7204
SELECT * FROM T_EMP2;

SELECT AVG(e.PAY) 
FROM T_EMP2 e,T_DEPT2 d GROUP BY e.DEPTNO;

SELECT d.DNAME 부서명,e.NAME 작원명,e.PAY 연봉
FROM T_EMP2 e,T_DEPT2 d
WHERE e.DEPTNO = d.DCODE 
AND e.PAY < ALL (SELECT AVG(PAY) 
FROM T_EMP2 GROUP BY DEPTNO)
ORDER BY e.NAME ASC;

--#7205
SELECT a.NAME 사원이름, NVL(a.POST,' ') 직급, a.PAY 급여
FROM  T_EMP2 a
WHERE a.PAY >= (SELECT AVG(b.PAY) 
FROM T_EMP2 b WHERE NVL(b.POST,' ') = NVL( a.POST,' '));

SELECT AVG(b.PAY) 
FROM T_EMP2 b WHERE b.POST = '과장';


-- 스칼라 서브쿼리 방식
SELECT 
name "사원이름", 
(SELECT dname FROM t_dept2 d
	WHERE e.deptno = d.dcode ) "부서이름"
FROM t_emp2 e;














