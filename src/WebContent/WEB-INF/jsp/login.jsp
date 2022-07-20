<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel = "stylesheet" href = "/miemo/css/login.css">
<script type = "text/javascript" src ="/miemo/js/script.js"></script>
</head>
<body>

<!-- サーブレットへ遷移させる -->
<form method = "POST" action = "/miemo/FrontControllerServlet">
<input type="hidden" name="page_id" value="FL01">
 <input type = "text" name = "number" value = "${param.number}">
 <input type = "password" name = "pw" value = "">
 <input type = "submit" name = "bt_name" value = "ログイン">

</form>


</body>
</html>