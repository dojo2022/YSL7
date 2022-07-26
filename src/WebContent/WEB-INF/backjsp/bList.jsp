<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Miemo|社員一覧</title>
</head>
<body>
<h1>YSL 社員一覧</h1>

<a href="/miemo/BControllerServlet?page_id=BL01&bt_name=to_regist_user" >新規社員登録</a>
<a href="/miemo/BControllerServlet?page_id=BL01&bt_name=to_front" >社員用画面に戻る</a>
<form method="GET" action="/miemo/BControllerServlet">
<input type="hidden" name="page_id" value="BL01">
	<table>
		<tr>
		<th>社員番号</th>
		<th>名前</th>
		<th>部署</th>
		<th>役職</th>
		<th>入社年度</th>
		</tr>
		<c:forEach var="list" items="${listAll}">
		<tr>
			<td>
			<input type="hidden" name="empId" value="${list.empId}">
			<input type="hidden" name="bt_name" value="to_profile">
			<input type="submit" value="${list.number} ${list.name}${list.department}${list.division}${list.section}${list.post}${list.year}"
				name="empData"></td>
		</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>