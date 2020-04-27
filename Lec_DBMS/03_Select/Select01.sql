-- dual 은 ROW 1개 짜리 dummy TABLE;
SELECT 'abcde' FROM dual;
SELECT '안녕하세요' FROM dual;
SELECT 100 FROM dual;
SELECT 100 + 10 FROM dual;

-- * : '모든 컬럼'
SELECT * FROM t_emp;

-- 원하는 컬럼만 조회 
SELECT EMPNO , ENAME 
FROM t_emp;

--
SELECT * FROM t_professor;
SELECT bonus FROM t_professor;

SELECT '안녕하세요' FROM t_professor;

SELECT name, '교수님 싸랑해요' FROM t_professor;


-- 컬럼 별명(alias) 사용한 출력
SELECT STUDNO 학번, name 이름 FROM T_STUDENT;

SELECT STUDNO "학번", NAME AS 이름 FROM T_STUDENT; 

SELECT STUDNO "학생 학번 " FROM T_STUDENT;

SELECT EMPNO "사원 번호" , ENAME 사원명, JOB 직업 FROM T_EMP;

SELECT DEPTNO "부서#" , DNAME 부서명 , LOC 위치 FROM T_DEPT;

--DISTINCT
SELECT * FROM T_EMP;
SELECT DEPTNO FROM T_EMP;
SELECT DISTINCT DEPTNO FROM T_EMP;

-- DISTINCT 연습
-- 학생테이블(t_student) 에서
-- 제1전공 (deptno1) 을 중복값을 제거하여 출력해보기

SELECT DISTINCT deptno1 FROM t_student;

-- 직원(t_emp) 들의 직책(job) 을 중복값 제거하여 출력해보기
SELECT DISTINCT job FROM t_emp;

--|| : 필드, 문자열 연결 연산
SELECT NAME, POSITION FROM T_PROFESSOR;

SELECT NAME || '-' || POSITION AS 교수님명단 FROM T_PROFESSOR;

SELECT NAME || '의 키는 ' || HEIGHT || 'cm,' || WEIGHT || 'kg입니다' AS "학생의 키와 몸무게" FROM T_STUDENT;
