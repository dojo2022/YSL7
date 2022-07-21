<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" href="/miemo/css/profile.css">
</head>
<body>
	<!-- Servletへ遷移させる(PassWord変更) -->
	<form method="POST" action="multiMVC2/ControllerServlet">
		<input type="hidden" name="pageId" value="FP01">
		現在のパスワード：<input type="text" name="nowpassbox">
		新しいパスワード：<input type="text" name="newpassbox">
		新しいパスワード確認：<input type="text" name="newpass2box">
		<input type="submit" name="bt_name" value="変更">
	</form>
	<!-- エラーメッセージの表示欄 -->
	<div id="errMsg">${errMsg}</div>
</body>
</html>


