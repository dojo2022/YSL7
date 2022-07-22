<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/miemo/backcss/bStyle.css">
<link rel="stylesheet" href="/miemo/backcss/bNote.css">
<script type="text/javascript" src="/miemo/js/bNote.js"></script>
<script type="text/javascript" src="/miemo/js/backCommon.js"></script>
 <script src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
 <script>
    jQuery(function($){
    	 // デフォルトの設定を変更（日本語化）--------------------
        $.extend( $.fn.dataTable.defaults, {
            language: {
                url: "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
            }
        });
    	 //------------------------------------------------
    	//データテーブルを使用
        $("#foo-table").DataTable();
    });
 </script>
<meta charset="UTF-8">
</head>
<body>
 <% session.setAttribute("notesList", "notesList"); %>
<form method="POST" action="/miemo/BControllerServlet" onsubmit="check()">
<table border="1" id="foo-table" class="table table-bordered">
	<tr>
		<td><a href="/miemo/BControllerServlet?page_id = BP01&bt_name=to_regist_user"><input type="button" value="新規作成"></a><td>
	</tr>
	<tr>
		<th>日付</th>
		<th>作成者</th>
		<th>タイトル</th>
		<th>内容</th>
	</tr>
	<tr>
		<c:forEach var="e" items="${notesList}">
			<td>${e.date}</td>
			<td>${e.from_name}</td>
			<td>${e.title}</td>
			<td>${e.content}</td>
			<input type="hidden" name="noteId" value="${e.noteId}">
			<td><input type="submit" name="nDelete" value="削除"></td>
		</c:forEach>
	</tr>
</table>
</form>
</body>
</html>