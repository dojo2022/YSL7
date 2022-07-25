<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel = "stylesheet" href = "/miemo/css/login.css">
<link rel = "stylesheet" href = "/miemo/css/common.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">

<script type = "text/javascript" src ="/miemo/js/script.js"></script>
</head>
<body>
<%-- <%@ include file="/WEB-INF/jsp/common.jsp" %> --%>
<div class="logo">
<img src="/miemo/img/Logo_mark.png"  alt="ロゴ" title="MiEmo" >
</div>
<!-- サーブレットへ遷移させる -->
<form method = "POST" action = "/miemo/FrontControllerServlet">
<input type="hidden" name="page_id" value="FL01">
	<table class ="login_center">
	<tr>
		<td id = "size_test" >【社員番号】</td>
		<td>
			<input class= "member_number" type = "text" name = "number" value = "${param.number}">
		</td>
	</tr>
	<tr>
		<td id = "size_test2">【パスワード】</td>
		<td>
			<input type="checkbox" id="checkPassword">
			<div class="togglePassword">
				<input type="password" name="password" class="hideText" value="">
				<input type="text" class="showText" value="">
				<label for="checkPassword" class="fa fa-eye"></label>
				<label for="checkPassword" class="fa fa-eye-slash"></label>
			</div>
		</td>
			<td>
			<input class="btn-circle-stitch" type = "submit" name = "bt_name" value = "ログイン">
			</td>
		</tr>
    </table>
</form>

<!-- エラーメッセージの表示欄 -->
	<div id="errMsg">${errMsg}</div>

</body>
</html>







