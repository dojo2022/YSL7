<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="/miemo/css/profile.css">
</head>
<body>

	<!-- Servletへ遷移させる(PassWord変更) -->
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="hidden" name="page_id" value="FP01">
		<input type="hidden" name="user_id" value="${user.userId }">
		<table>
			<tr>
				<td>名前:</td>
				<td>${users.name}</td>
			</tr>
			<tr>
				<td>社員番号：</td>
				<td>${users.number}</td>
			</tr>
			<tr>
				<td>部署：</td>
				<td>${users.department}</td>
			</tr>
			<tr>
				<td>事業部：</td>
				<td>${users.division}</td>
			</tr>
			<tr>
				<td>課：</td>
				<td>${users.section}</td>
			</tr>
			<tr>
				<td>役職：</td>
				<td>${users.post}</td>
			</tr>
			<tr>
				<td>入社年度：</td>
				<td>${users.year}</td>
			</tr>
			<tr>
				<td>新しいパスワード：</td>
				<td><input type="text" name="newpassbox"></td>
			</tr>
			<tr>
				<td>新しいパスワード確認：</td>
				<td><input type="text" name="newpass2box"></td>
			</tr>
			</table>
		<input type="submit" name="bt_name" value="変更">
	</form>
	<!-- エラーメッセージの表示欄 -->
	<div id="errMsg">${errMsg}</div>
</body>
</html>


