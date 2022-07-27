<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
 <link rel="stylesheet" href="/dataTableSample/backcss/list.css" />
 <script src="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.js"></script>
 <link rel="stylesheet" href="/miemo/backcss/bStyle.css">
 <link rel="stylesheet" href="/miemo/backcss/bList.css">
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
<title>Miemo|社員一覧</title>
<link rel="stylesheet" href="/miemo/backcss/bList.css">

</head>
<body>
<h1>YSL 社員一覧</h1>

<a href="/miemo/BControllerServlet?page_id=BL01&bt_name=to_front" class=back_button >社員用画面へ</a>
<a href="/miemo/BControllerServlet?page_id=BL01&bt_name=to_regist_user" class=regist_button >新規社員登録</a>


	<div class=b_list>
	<table border="1" id="foo-table" class="table table-bordered">
		<thead>
			<tr>
				<th class="list_header">社員番号</th>
				<th class="list_header">名前</th>
				<th class="list_header">部署</th>
				<th class="list_header">役職</th>
				<th class="list_header">入社年度</th>
				<th class="list_header">button</th>
			</tr>
		</thead>

		<c:forEach var="list" items="${listAll}" varStatus="status">

				<tr>
					<form method="GET" action="/miemo/BControllerServlet">
						<td id="sh_data">${list.number}</td>
						<td class="sh_d">${list.name}</td>
						<td class="sh_d">${list.department}${list.division}${list.section}</td>
						<td class="sh_d">${list.post}</td>
						<td class="sh_d">${list.year}</td>

						<td class="p_display"><input type="submit" name="button"  value="表示">
						<input type="hidden" name="page_id" value="BL01">
						<input type="hidden" name="emp_id" value="${list.empId}" >
						<input type="hidden" name="bt_name" value="to_profile">
						</td>
					</form>
				</tr>

	<%-- 		<tr>
				<td>

				<input type="submit" value="${list.number} ${list.name}${list.department}${list.division}${list.section}${list.post}${list.year}"
					name="empData"></td>
			</tr> --%>
		</c:forEach>
	</table>
	</div>

</body>
</html>