<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
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
<title>評価相手検索画面</title>
</head>
<body>
	<!-- サーブレットへ遷移させる -->



<h1>評価シート</h1>
	<table border="1" id="foo-table" class="table table-bordered">
		<thead>
			<tr>
				<th>社員番号</th>
				<th>名前</th>
				<th>部署</th>
				<th>役職</th>
				<th>チェック</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${list}" varStatus="status">
				<tr>
					<form method="POST" action="/miemo/FrontControllerServlet">
						<input type="hidden" name="page_id" value="FE01">
						<td>${e.userId}<input type="hidden" name="user_id" value="${e.userId}"></td>
						<td>${e.name}<input type="hidden" name="evaluate_name" value="${e.name}"></td>
						<td>${e.department}</td>
						<td>${e.post}</td>
						<td><input type="submit" name="bt_name" value="評価する"></td>
					</form>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>