<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
	<link rel="stylesheet" href="/miemo/backcss/bStyle.css">
	<link rel="stylesheet" href="/miemo/backcss/bNote.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
	<script type="text/javascript" src="/miemo/backjs/bNote.js"></script>
	<script type="text/javascript" src="/miemo/backjs/backCommon.js"></script>
	<meta charset="UTF-8">
	<title>Miemo|</title>
</head>
<body>
<a href="/miemo/BControllerServlet?page_id=BP01&bt_name=to_regist_note" ><input type=button value="新規作成" class="nRegistButton"></a>
	<c:if test="${notesList.size()!=0}">
		<form method="POST" action="/miemo/BControllerServlet" onsubmit="check()">
		<table border="1" id="foo-table" class="table table-bordered table_blue_stripe">
		<thead>
			<tr class="n-tablehead">
				<th>日付</th>
				<th>作成者</th>
				<th>タイトル</th>
				<th>内容</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="e" items="${notesList}" varStatus="status">
				<tr class="n-tabledata">
					<td>${e.date}</td>
					<td>${e.name}</td>
					<td>${e.title}</td>
					<td class="tw">
							<div class="content-wrap animated">
							  <div class="content-txt">
							    <p class="content">${e.content}</p></div>
							  <div class="more-btn">
							    <img src="/miemo/img/plusBtnRed.png" class="open">
							  </div>
							</div>
					</td>
					<td><input type="submit" name="nDelete" value="削除" class="nDelete"></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</form>
	</c:if>
	<c:if test="${notesList.size()==0}">
		<h3>まだメモがありません。メモを登録してみましょう！</h3>
	</c:if>
</body>
</html>