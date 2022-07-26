<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<!-- ハンバーガーサンプル1 machioco版 -->
<div class="cp_cont">
	<div class="cp_offcm01">
		<input type="checkbox" id="cp_toggle01"> <label for="cp_toggle01"></label>
		<div class="cp_menu">
			<ul>
					<li><a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=hr">ホーム</a></li>
					<li><a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=regist_feeling">きもち記録</a></li>
					<li><a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=history_feeling">きもち履歴</a></li>
					<li><a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=graph_feeling">きもちグラフ</a></li>
					<li><a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=evaluation">評価</a></li>
					<li><a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=profile">プロフィール</a></li>
					<li><a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=message">メッセージ</a></li>
					<li><a href="http://localhost:8080/miemo/FrontControllerServlet">ログアウト</a></li>
					<li class="sidemenu_calendar_item">
						<label>
							<input type="checkbox" name="checkbox" class="context_button">
						</label>
					</li>
				</ul>
		</div>
	</div>
</div>

</body>
</html>