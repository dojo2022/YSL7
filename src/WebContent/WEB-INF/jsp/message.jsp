<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メッセージ</title>
<link rel="stylesheet" type="text/css" href="/miemo/css/common.css">
<link rel="stylesheet" type="text/css" href="/miemo/css/message.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
	<h1>Message</h1>
		<h2>メッセージは人事部にのみ送られます</h2>
	<!-- Servletへ遷移させる -->
	<form method="POST" action="/miemo/FrontControllerServlet" class="message">
		<input type="hidden" name="page_id" value="FM01">
		<!--  <input type="text" name="message" value="${param.message}"><br>-->
		<textarea name="message"></textarea><br>
			<input type="submit" name="bt_name" value="送信"  class="button">
	</form>
	<!-- エラーメッセージの表示欄 -->
	<div id="errMsg">${errMsg}</div>

</body>
</html>