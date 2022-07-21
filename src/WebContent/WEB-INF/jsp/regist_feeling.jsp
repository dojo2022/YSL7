<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="text" name="stamp_id" value="${param.stampId }">
		<input type="text"  name="stamp1" value="${param.stamp1}">
		<input type="text"  name="stamp2" value="${param.stamp2}">
		<input type="text"  name="stamp3" value="${param.stamp3}">
		<input type="text"  name="stamp4" value="${param.stamp4}">
		<input type="text"  name="stamp5" value="${param.stamp5}">
		<input type="text"  name="category_id" value="${param.category_id}">
		<input type="text"  name="comment" value="${param.comment}">
		<input type="submit"  name="bt_name" value="登録">
	</form>

</body>
</html>