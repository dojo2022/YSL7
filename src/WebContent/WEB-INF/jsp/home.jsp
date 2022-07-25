<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/miemo/css/common.css">
</head>
<body>
	<table>

	${errMsg }<br>
	<tr>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=regist_feeling">きもち記録</a>
	</td>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=history_feeling">きもち履歴</a>
	</td>

	</tr>

	<tr>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=graph_feeling">きもちグラフ</a>
	</td>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=evaluation">評価</a>
	</td>
	</tr>

	<tr>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=profile">プロフィール</a>
	</td>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=message">メッセージ</a>
	</td>
	</tr>

	</table>

	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=hr">人事部画面へ</a>



</body>
</html>