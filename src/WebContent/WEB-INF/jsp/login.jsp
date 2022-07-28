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
<div class="logo">
<img src="/miemo/img/Logo_mark.png"  alt="ロゴ" title="MiEmo" >
</div>
<!-- サーブレットへ遷移させる -->
<form method = "POST" action = "/miemo/FrontControllerServlet">
<input type="hidden" name="page_id" value="FL01">
	<table class ="login_center">
	<tr>
		<td class="button_area" id = "size_test" ><div id="login_text">社員番号</div></td>
		<td>
			<div class="field">
				<input class= "text" type = "text" name = "number" value = "${param.number}">
			</div>
		</td>
	</tr>
	<tr>
		<td class="button_area" id = "size_test2"><div id="login_text">パスワード</div></td>
		<td>
			<div class="field">
				<input type="password" name="password"  class="text" id="textPassword">
				<span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span>
			</div>
		</td>
			<td>
				<input class="btn-circle-stitch" type = "submit" name = "bt_name" value = "ログイン">
			</td>
		</tr>

    </table>
</form>

<!-- エラーメッセージの表示欄 -->
	<div class = "alert" id="errMsg">${errMsg}</div>

<script>
      function pushHideButton() {
        var txtPass = document.getElementById("textPassword");
        var btnEye = document.getElementById("buttonEye");
        if (txtPass.type === "text") {
          txtPass.type = "password";
          btnEye.className = "fa fa-eye";
        } else {
          txtPass.type = "text";
          btnEye.className = "fa fa-eye-slash";
        }
      }
    </script>

</body>
</html>







