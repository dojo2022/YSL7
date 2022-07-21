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
			<!-- テーブルの見出し -->
			<th>日付</th>
			<th>スタンプ</th>
			<th>カテゴリ</th>
			<th>内容</th>
		</tr>
		<c:forEach var="e" items="${allStamps}">
		<tr>
			<!-- 日付のセル -->
			<td>${e.date}</td>
			<!-- スタンプのセル -->
			<td>
				<c:if test="${e.stamp1 == 1}"><img src=""></c:if>
				<c:if test="${e.stamp2 == 1}"><img src=""></c:if>
				<c:if test="${e.stamp3 == 1}"><img src=""></c:if>
				<c:if test="${e.stamp4 == 1}"><img src=""></c:if>
				<c:if test="${e.stamp5 == 1}"><img src=""></c:if>
			</td>
			<!-- カテゴリのセル -->
			<td>${e.category}</td>
			<!-- コメントのセル -->
			<td>${e.comment}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>