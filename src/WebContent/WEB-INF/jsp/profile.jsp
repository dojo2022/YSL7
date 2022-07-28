<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="/miemo/css/common.css">
<link rel="stylesheet" type="text/css" href="/miemo/css/profile.css">
 <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
</head>
<body>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
	<!-- Servletへ遷移させる(PassWord変更) -->

	<form method="POST" action="/miemo/FrontControllerServlet">
		<h1 id="midashi">プロフィール</h1>
		<input type="hidden" name="page_id" value="FP01">
		<input type="hidden" name="user_id" value="${user.userId }">
		<div>
		<table class = profile>
			<tr>
				<th>名前</th>
				<td>${users.name}</td>
			</tr>
			<tr>
				<th>社員番号</th>
				<td>${users.number}</td>
			</tr>
			<tr>
				<th>部署</th>
				<td>${users.department}</td>
			</tr>
			<tr>
				<th>事業部</th>
				<td>${users.division}</td>
			</tr>
			<tr>
				<th>課</th>
				<td>${users.section}</td>
			</tr>
			<tr>
				<th>役職</th>
				<td>${users.post}</td>
			</tr>
			<tr>
				<th>入社年度</th>
				<td>${users.year}</td>
			</tr>
			</table>
			<h2 id="komidashi">*パスワード変更*</h2>
			<table  class = profile>
			<tr>
				<th>新しいパスワード</th>
				<td><input type="text" name="newpassbox" maxlength="8"><br>
				(最大8文字)</td>
			</tr>
			<tr>
				<th>新しいパスワード確認</th>
				<td><input type="text" name="newpass2box" maxlength="8"></td>
			</tr>
		</table><br>
		</div>
		<input type="submit" name="bt_name" value="変更" class="update_btn">
	</form>

	<!-- エラーメッセージの表示欄 -->
	<br><div class = "alert" id="errMsg">${errMsg}</div>
</body>
</html>


