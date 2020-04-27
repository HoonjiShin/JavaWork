-- 묵시적 자동 형변환 예
SELECT 1 + 1 FROM dual;
SELECT '1' + 1 FROM dual;

SELECT to_number('1') + 1 FROM dual;

--###########################################3
-- TO_CHAR 함수  (날짜 -> 문자)
SELECT 
	SYSDATE,
	TO_CHAR(SYSDATE, 'YYYY') 연도4자리,
	TO_CHAR(SYSDATE, 'RRRR')  연도Y2K버그이후,
	TO_CHAR(SYSDATE, 'YY')  연도2자리,
	TO_CHAR(SYSDATE, 'YEAR') 연도영문
FROM dual;

SELECT
	TO_CHAR(SYSDATE, 'DD') 일숫자2자리,
	TO_CHAR(SYSDATE, 'DDTH') 몇번째날, 
	TO_CHAR(SYSDATE, 'DAY') 요일,
	TO_CHAR(SYSDATE, 'Dy') 요일앞자리
FROM dual;

SELECT
	TO_CHAR(SYSDATE, 'MM') 월2자리,
	TO_CHAR(SYSDATE, 'MON') 월3자리,  -- 7월
	TO_CHAR(SYSDATE, 'MONTH')  월전체,  -- 7월
	TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월영문3자리,  -- JUL
	TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(대)", -- JULY
	TO_CHAR(SYSDATE, 'month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(소)",  -- july
	TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(첫글자대)" -- July
FROM dual;

SELECT 
	TO_CHAR(SYSDATE, 'HH24') 시24hr,
	TO_CHAR(SYSDATE, 'HH')  시12hr,
	TO_CHAR(SYSDATE, 'MI') 분,
	TO_CHAR(SYSDATE, 'SS') 초,
	TO_CHAR(SYSDATE, 'HH:MI:SS')
FROM dual;
-- #4301
-- 다음과 같은 형식으로 시간을 출력해보세요
-- ex) 2017-10-25:23:25:46
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') 날짜
FROM dual;

-- 2017년10월25일 23시25분46초  <-- ??
-- 한글 date format 변환시
SELECT SYSDATE, TO_CHAR(SYSDATE, 'YYYY"년"MM"월"DD"일" HH24"시"MI"분"SS"초"') 날짜
FROM dual;

-- #4302
-- 실습
-- t_student 테이블의 생일(birthday) 이 3월인 학생의 이름(name) 과 생일(birthday) 를 
-- 다음과 같은 형식으로 출력하세요 (TO_CHAR 사용)
SELECT NAME, BIRTHDAY FROM T_STUDENT WHERE TO_CHAR(BIRTHDAY,'MM') = 03 ;

--################################################3
-- TO_CHAR() 함수  - 숫자를 문자로 변환
SELECT 1234,TO_CHAR(1234, '99999')  "9하나당 1자리",
	TO_CHAR(1234, '099999')  "빈자리 0으로",
	TO_CHAR(1234, '$9999')  "$붙임",
	TO_CHAR(1234, '9999.99')  "소수점이하",
	TO_CHAR(1234, '99,999')  "천단위구분기호"
 FROM DUAL;

SELECT NAME , TO_CHAR( PAY *12 +NVL(BONUS ,0),'9,999') 연봉 FROM T_PROFESSOR WHERE DEPTNO =101;

--##############################################################3
-- TO_NUMBER() 함수 - 숫자로 변환
SELECT TO_DATE('2020-12-20','YYYY-MM-DD') TO_DATE FROM DUAL;

SELECT NAME,HIREDATE,TO_CHAR((PAY *12),'99,999') 연봉, TO_CHAR(((PAY *12)+(PAY*0.1)),'99,999') 인상  FROM T_PROFESSOR WHERE HIREDATE < '2000-01-01';