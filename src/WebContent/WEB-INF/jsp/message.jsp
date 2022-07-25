<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
<link rel="stylesheet" href="/miemo/css/common.css">
<link rel="stylesheet" href="/miemo/css/message.css">
</head>
<body>

	<!-- Servletへ遷移させる -->
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="hidden" name="page_id" value="FM01">
		<h1>Message</h1>
		<p>メッセージは人事部にのみ送られます</p>
		<!--  <input type="text" name="message" value="${param.message}"><br>-->
		<textarea rows="10" name="message" cols="60"></textarea>
			<input type="submit" name="bt_name" value="送信"  class="button">
	</form>
	<!-- エラーメッセージの表示欄 -->
	<div id="errMsg">${errMsg}</div>

</body>
</html>