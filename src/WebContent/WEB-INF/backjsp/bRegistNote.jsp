<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Miemo|新規メモ登録</title>
</head>
<body>
<h2>${emp.name}さんの新規メモ</h2>
<form method=POST name=registNote>
	<table class="registNote">
		<tr>
			<th>タイトル</th>
		</tr>
		<tr>
			<td><input type="text" name="title"></td>
			<td><input type="hidden" name="emp_id" value="${emp.uId}"></td>
		</tr>
		<tr>
			<th>内容</th>
		</tr>
		<tr>
			<td><textarea name="content"></textarea></td>
			<td><input type="hidden" name="page_id" value="BN01"></td>
		</tr>
		<tr>
			<td><a href="/Miemo/bControllerServlet/"><input type="button" value="戻る"></a></td>
			<td><input type="submit" name="bt_name" value="保存"></td>
		</tr>
	</table>
</form>
</body>
</html>
