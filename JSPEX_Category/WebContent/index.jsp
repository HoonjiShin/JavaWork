<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/CSS/common.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="JS/category.js"></script>
<title>다단계 카테고리 - SELECT 하기</title>
</head>
<body>
<h2>다단계 카테고리 - SELECT 하기</h2>
<div class="cate" id="mycate">
<span>
	<select id="mycate1" disabled></select>
</span>
<span>
	<select id="mycate2" disabled></select>
</span>
<span>
	<select id="mycate3" disabled></select>
</span>
</div>
</body>
</html>