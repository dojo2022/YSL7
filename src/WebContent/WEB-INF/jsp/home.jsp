<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
		<head>
	<meta charset="UTF-8">
		<title>Insert title here</title>

		<link rel = "stylesheet" href = "/miemo/css/home.css">
		<link rel="stylesheet" href="/miemo/css/common.css">
	</head>
	<h1>ホーム</h1>
	<body>
	<%@ include file="/WEB-INF/jsp/common.jsp" %>
	<table class = home_table >

	<tr>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=regist_feeling" class="btn btn-tag btn-tag--favorite"><i class="fas fa-star"></i>きもち記録</a>
	</td>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=history_feeling" class="btn btn-tag btn-tag--favorite"><i class="fas fa-star"></i>きもち履歴</a>
	</td>

	</tr>

	<tr>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=graph_feeling" class="btn btn-tag btn-tag--favorite"><i class="fas fa-star"></i>きもちグラフ</a>
	</td>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=evaluation" class="btn btn-tag btn-tag--favorite"><i class="fas fa-star"></i>評価</a>
	</td>
	</tr>

	<tr>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=profile" class="btn btn-tag btn-tag--favorite"><i class="fas fa-star"></i>プロフィール</a>
	</td>
	<td>
	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=message" class="btn btn-tag btn-tag--favorite"><i class="fas fa-star"></i>メッセージ</a>
	</td>
	</tr>

	</table>

	<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=hr" class="btn btn-tag btn-tag--ver"><i class="fas fa-star"></i>人事部画面へ</a>



</body>
</html>