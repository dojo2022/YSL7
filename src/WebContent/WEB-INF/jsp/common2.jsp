<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/miemo/css/common2.css">

</head>
<body>
<!-- ハンバーガーサンプル1 machioco版 -->
<div class="cp_cont">
	<div class="cp_offcm01">
		<input type="checkbox" id="cp_toggle01"><label for="cp_toggle01">
		<div><img src="/miemo/img/sidemenu_icon.png" style="display: block; margin: auto;" width="60px" height="60px"></div>
		</label>
		<div class="cp_menu">
				<ul>
					<div>
					<li><a
						href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=home" > ホーム</a></li>
					</div>
					<li><a
						href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=regist_feeling">きもち記録</a></li>
					<li><a
						href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=history_feeling">きもち履歴</a></li>
					<li><a
						href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=graph_feeling">きもちグラフ</a></li>
					<li><a
						href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=evaluation">評価</a></li>
					<li><a
						href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=profile">プロフィール</a></li>
					<li><a
						href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=message">メッセージ</a></li>
					<li id="logout"><a
						href="http://localhost:8080/miemo/FrontControllerServlet" onclick="return confirm('ログアウトしてもよろしいですか')">ログアウト</a></li>
					<li class="sidemenu_calendar_item"></li>
				</ul>
			</div>
	</div>
</div>

</body>
</html>