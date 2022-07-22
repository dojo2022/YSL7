<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setAttribute("sample", "サンプル"); %>
 <% session.setAttribute("sample", "サンプル"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Miemo|新規メモ登録</title>
</head>
<body>
<h2>${emp.name}さんの新規メモ</h2>
<form method=POST action="/Miemo/bControllerServlet/">
	<table class="registNote">
		<tr>
			<th>タイトル</th>
		</tr>
		<tr>
			<td><input type="text" name="title"></td>
			<td><input type="hidden" name="emp_id" value="${emp.uId}"></td>
		</tr>
		<tr><td>${errMsgTitle}</td></tr>
		<tr>
			<th>内容</th>
		</tr>
		<tr>
			<td><textarea name="content"></textarea></td>
			<td><input type="hidden" name="page_id" value="BN01"></td>
		</tr>
		<tr><td>${errMsgContent}</td></tr>
		<tr>
		<!-- 戻るボタンはjsのhistorybackを使います -->
			<td><input type="button" value="戻る" id="noteReturn"></td>
			<td><input type="submit" name="bt_name" value="保存"></td>
		</tr>
	</table>
</form>
</body>
</html>
