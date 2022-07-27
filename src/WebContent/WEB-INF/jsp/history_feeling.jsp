<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>きもち履歴</title>

<link rel="stylesheet" href="/miemo/css/history_feeling.css">
<link rel="stylesheet" type="text/css" href="/miemo/css/common.css">
 <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
</head>

<body>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<h1 id="h1title">きもち履歴</h1>
<table class="stamps">
<tr>
	<!-- テーブルの見出し -->
	<th class="items">日付</th>
	<th class="items">スタンプ</th>
	<th class="items">カテゴリ</th>
	<th class="items_content">内容</th>
	<th class="items">編集</th>
</tr>
<c:forEach var="e" items="${historyList }">
<tr>
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="hidden" name="page_id" value="FF02">
		<input type="hidden" name="stamp_id" value="${e.stampId }">
			<td class="data">${e.date}<input type="hidden" name="stamp_id" value="${e.date }"></td>
			<td class="data">
				<c:if test="${e.stamp1 == 1 }">
					<img src="/miemo/img/stamp1.png" width="40px" class="stamp_img">
					<input type="hidden" name="stamp1" value="${e.stamp1}">
				</c:if>
				<c:if test="${e.stamp2 == 1 }">
					<img src="/miemo/img/stamp2.png" width="40px" class="stamp_img">
					<input type="hidden" name="stamp2" value="${e.stamp2}">
				</c:if>
				<c:if test="${e.stamp3 == 1 }">
					<img src="/miemo/img/stamp3.png" width="40px" class="stamp_img">
					<input type="hidden" name="stamp3" value="${e.stamp3}">
				</c:if>
				<c:if test="${e.stamp4 == 1 }">
					<img src="/miemo/img/stamp4.png" width="40px" class="stamp_img">
					<input type="hidden" name="stamp4" value="${e.stamp4}">
				</c:if>
				<c:if test="${e.stamp5 == 1 }">
					<img src="/miemo/img/stamp5.png" width="40px" class="stamp_img">
					<input type="hidden" name="stamp5" value="${e.stamp5}">
				</c:if>
			</td>
			<td class="data">${e.category}<input type="hidden" name="category" value="${e.category}">
			<input type="hidden" name="category_id" value="${e.categoryId}"></td>
			<td class="content_data">${e.comment}<input type="hidden" name="comment" value="${e.comment}"></td>
			<td class="data"><input type="submit" name="bt_name" value="編集画面へ" class="btn"></td>
	</form>
</tr>
</c:forEach>
</table>


</body>

</html>