<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

 <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>
 <link rel="stylesheet" href="/dataTableSample/backcss/list.css" />
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
<title>絞り込みサンプル</title>

</head>
<body>

	<table border="1" id="foo-table" class="table table-bordered">
		<thead>
			<tr>
				<th id="sh_head">社員番号</th>
				<th class="sh_h">名前</th>
				<th class="sh_h">部署</th>
				<th class="sh_h">役職</th>
				<th class="sh_h">入社年度</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${list}" varStatus="status">

				<tr class="emp" onclick="return goDate('${status.index}')<!-- ここ、ほんとはEmpId -->" >
					<td id="sh_data"><%-- ${e.empdept} --%>ダミーデータ</td>
					<td class="sh_d"><%-- ${e.empdept} --%>ダミーデータ</td>
					<td class="sh_d"><%-- ${e.empdept} --%>ダミーデータ</td>
					<td class="sh_d"><%-- ${e.position} --%>ダミーデータ</td>
					<td class="sh_d"><%-- ${e.year} --%>ダミーデータ</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<script>
	function goDate(indexNo){
		alert(indexNo);
	}




	</script>
</body>
</html>