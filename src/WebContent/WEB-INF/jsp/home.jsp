<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
		<head>
	<meta charset="UTF-8">
		<title>ホーム</title>
		<link rel="stylesheet" href="/miemo/css/common.css">
		<link rel = "stylesheet" href = "/miemo/css/home.css">
		 <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
	</head>
	<body>
	<%@ include file="/WEB-INF/jsp/common.jsp" %>

	<h1 id="midashi">ホーム</h1>

	<div id="err_m">${errMsg}</div>

	<div id="home_tb">
	<table class = home_table >
		<tr>
			<td class="home_td">
				<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=regist_feeling" class="btn1"><i class="fas fa-star"></i>きもち記録</a>
			</td>
			<td class="home_td">
				<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=history_feeling" class="btn2"><i class="fas fa-star"></i>きもち履歴</a>
			</td>

			<td class="home_td">
				<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=graph_feeling" class="btn3"><i class="fas fa-star"></i>きもちグラフ</a>
			</td>
		</tr>

		<tr>
			<td class="home_td">
				<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=evaluation" class="btn4"><i class="fas fa-star"></i>評価シート</a>
			</td>
			<td class="home_td">
				<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=profile" class="btn5"><i class="fas fa-star"></i>プロフィール</a>
			</td>
			<td class="home_td">
				<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=message" class="btn6"><i class="fas fa-star"></i>メッセージ</a>
			</td>
		</tr>

		<tr></tr>
		<tr></tr>

		<tr>
		  <td class = "btn7_td">
			<c:if test="${user.number.equals('L10003') || user.number.equals('L10004') }">
			<a href="/miemo/FrontControllerServlet?page_id=FH01&bt_name=hr" class="btn7"><i class="fas fa-star"></i>人事部画面へ</a>
	        </c:if>
	       </td>
	    </tr>
	</table>
	</div>
</body>
</html>