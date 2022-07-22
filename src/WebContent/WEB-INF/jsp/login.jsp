<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel = "stylesheet" href = "/miemo/css/login.css">
 <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<script type = "text/javascript" src ="/miemo/js/script.js"></script>
</head>
<body>

<!-- サーブレットへ遷移させる -->

	<table>
	<form method = "POST" action = "/miemo/FrontControllerServlet">
	<input type="hidden" name="page_id" value="FL01">

	<tr>
		<td>社員番号</td>
		<td>
			<input class= "number" type = "text" name = "number" value = "${param.number}">
		</td>
	</tr>


	<tr>
		<td>パスワード</td>
		<td>
			<input type="checkbox" id="checkPassword" class="ch">
			<div class="togglePassword">
				<input type="password" class="hideText" value="">
				<input type="text" class="showText" value="">
				<label for="checkPassword" class="fa fa-eye"></label>
				<label for="checkPassword" class="fa fa-eye-slash"></label>
			</div>
		</td>
	</tr>

	</form>
	</table>

<input type = "submit" name = "bt_name" value = "ログイン">





</body>
</html>