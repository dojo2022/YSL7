<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/miemo/backcss/bStamps.css">
<title>きもちグラフ | miemo</title>
</head>
<body>
	<table class="stamps">
		<tr>
			<!-- テーブルの見出し -->
			<th class="items">日付</th>
			<th class="items">スタンプ</th>
			<th class="items">カテゴリ</th>
			<th class="items_content">内容</th>
		</tr>
 		<c:forEach var="e" items="${allStamps}">
		<tr>
			<!-- 日付のセル -->
			<td class="data">${e.date}</td>
			<!-- スタンプのセル -->
			<td class="data">
				<c:if test="${e.stamp1 == 1}"><img src="/miemo/img/stamp1.png" class="stamp"></c:if>
				<c:if test="${e.stamp2 == 1}"><img src="/miemo/img/stamp2.png" class="stamp"></c:if>
				<c:if test="${e.stamp3 == 1}"><img src="/miemo/img/stamp3.png" class="stamp"></c:if>
				<c:if test="${e.stamp4 == 1}"><img src="/miemo/img/stamp4.png" class="stamp"></c:if>
				<c:if test="${e.stamp5 == 1}"><img src="/miemo/img/stamp5.png" class="stamp"></c:if>
			</td>
			<!-- カテゴリのセル -->
			<td class="data">${e.category}</td>
			<!-- コメントのセル -->
			<td class="content_data">${e.comment}</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>