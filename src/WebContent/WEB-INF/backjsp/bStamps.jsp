<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>きもちグラフ | miemo</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>日付</th>
			<th>スタンプ</th>
			<th>カテゴリ</th>
			<th>内容</th>
		</tr>
		<c:forEach var="e" items="${allStamps}">
		<tr>
			<td>${e.date}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>