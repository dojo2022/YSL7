<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Miemo|新規メモ登録</title>
<link rel="stylesheet" href="/miemo/backcss/bStyle.css">
<link rel="stylesheet" href="/miemo/backcss/bRegistNote.css">
<script type="text/javascript" src="/miemo/js/bRegistNote.js"></script>
<script type="text/javascript" src="/miemo/js/backCommon.js"></script>
</head>
<body>
<h2>${user.name}さんの新規メモ</h2>
<form method=POST action="/miemo/bControllerServlet/" onsubmit="check()">
	<table class="registNote">
		<tr>
			<th>タイトル</th>
		</tr>
		<tr>
			<td><input type="text" name="title" class="title"></td>
			<td><input type="hidden" name="emp_id" value="${user.userId}"></td>
		</tr>
		<tr><td class="ErrorMsg">${errMsgTitle}</td></tr>
		<tr>
			<th>内容</th>
		</tr>
		<tr>
			<td><textarea name="content"></textarea></td>
			<td><input type="hidden" name="page_id" value="BN01"></td>
		</tr>
		<tr><td class="ErrorMsg">${errMsgContent}</td></tr>
		<tr>
		<!-- 戻るボタンはjsのhistorybackを使います -->
			<td><input type="button" value="戻る" id="noteReturn"></td>
			<td><input type="submit" name="bt_name" value="保存" class="cNote"></td>
		</tr>
	</table>
</form>
</body>
</html>
