<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>評価シート画面</title>
</head>
<body>
	<!-- サーブレットへ遷移させる -->
	<form method="POST" action="/miemo/servlet/FrontControllerServlet">
		<input type="hidden" name="page_id" value="FE02">

	<h1>評価シート</h1>

	<!-- 評価先選択画面に戻るボタン -->
	<div class="button_area">
		<a href="/miemo/FrontControllerServlet?page_id=FE02&bt_name=evaluation">
		</a>
	</div>
	<!-- 評価相手の名前を表示 -->
	<c:forEach var="e" items="${list}" varStatus="status">
		<p>To:${e.name}</p>
	</c:forEach>

	<!-- ★評価 -->
	<div class="stars">
		<span>
			<table border="1" id="stars_table">
				<tr>
					<td>質問1</td><td><input id="evaluation1" type="radio" name="review"><label for="review01">★</label></td>
					<td>質問2</td><td><input id="evaluation2" type="radio" name="review"><label for="review02">★</label></td>
					<td>質問3</td><td><input id="evaluation3" type="radio" name="review"><label for="review03">★</label></td>
					<td>質問4</td><td><input id="evaluation4" type="radio" name="review"><label for="review04">★</label></td>
					<td>質問5</td><td><input id="evaluation5" type="radio" name="review"><label for="review05">★</label></td>
				</tr>
			</table>
		</span>
	</div>

	<!-- 登録ボタン -->
	<div>
		<input type="button" id="bt_name" value="登録" onclick="location.href='/miemo/FrontControllerServlet'">
	</div>

</body>
</html>