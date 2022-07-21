<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>きもち履歴</title>
</head>
<body>
<c:forEach var="e" items="${historyList }">
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="hidden" name="stamp_id" value="${e.stampId }">
		${e.date}<input type="hidden" name="stamp_id" value="${e.date }">
		${e.stamp1}<input type="hidden" name="stamp1" value="${e.stamp1}">
		${e.stamp2}<input type="hidden" name="stamp2" value="${e.stamp2}">
		${e.stamp3}<input type="hidden" name="stamp3" value="${e.stamp3}">
		${e.stamp4}<input type="hidden" name="stamp4" value="${e.stamp4}">
		${e.stamp5}<input type="hidden" name="stamp5" value="${e.stamp5}">
		${e.category}<input type="hidden" name="category" value="${e.category}">
		${e.comment}<input type="hidden" name="comment" value="${e.comment}">
		<input type="submit" name="bt_name" value="編集画面へ">
	</form>
</c:forEach>

</body>
</html>