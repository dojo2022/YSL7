<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/miemo/backcss/bMainPage.css">

</head>
<body>
<form action="/miemo/BControllerServlet" method="POST">
	<table class=profile>
		<tr>
			<td rowspan="2" class=name>${profile.name}</td>
			<td class="item">《社員番号》</td>
			<td class="item">《役職》</td>
		</tr>
		<tr>
		<td class="number">　${profile.number}</td>
		<td class="post">　${profile.post}</td>
		</tr>
		<tr>
			<td rowspan="3" class="gender">
			<c:if test="${profile.gender==0}">男性</c:if>
			<c:if test="${profile.gender==1}">女性</c:if>
			</td>
			<td class="item">《所属》</td>
			<td class="item">《入社年度》</td>
		</tr>
		<tr>
			<td class="department">　${profile.department}</td>
			<td class="year">　${profile.year}年</td>
		</tr>
		<tr>
			<td class="division">　${profile.division}部</td>
		</tr>
		<tr>
			<td></td>
			<td class="section">　${profile.section}課</td>
		</tr>
		<tr>
			<td class="back_button"><a href="/miemo/BControllerServlet?page_id=BP01&bt_name=back_list" class=back>一覧に戻る</a></td>
			<td></td>
			<td class="edit_button">
			<input type="submit" name="bt_name" value="編集" class=edit>
			<input type="hidden" name="page_id" value="BP01">
			</td>
		</tr>
	</table>
</form>

	<div class="tabs">
		<input id="all" type="radio" name="tab_item" checked>
		<!-- ここからタブ -->
			<label class="tab_item1" for="all">きもちグラフ</label>
			<input id="aaa" type="radio" name="tab_item">

			<label class="tab_item2"	for="aaa">きもちスタンプ</label>
			<input id="bbb" type="radio"	name="tab_item">

			<label class="tab_item3" for="bbb">メッセージ</label>
			<input id="ccc" type="radio"	name="tab_item">

			<label class="tab_item4" for="ccc">メモ</label>
			<input id="ddd" type="radio"	name="tab_item">

			<label class="tab_item5" for="ddd">評価</label>

		<!-- ここから内容 -->
			<div class="tab_content" id="all_content">
				<%-- <jsp:include page="bStampsGraph.jsp" /> --%>
			</div>

			<div class="tab_content" id="aaa_content">
				<jsp:include page="bStamp.jsp" />
			</div>

			<div class="tab_content" id="bbb_content">
				<%-- <jsp:include page="bMessages.jsp" /> --%>
			</div>

			<div class="tab_content" id="ccc_content">
				<%-- <jsp:include page="bNote.jsp" /> --%>
			</div>

			<div class="tab_content" id="ddd_content">
				<jsp:include page="bEvaluations.jsp" />
			</div>
	</div>
</body>
</html>