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
			<td rowspan="2" class=name>石貝真奈${profile.name}</td>
			<td class=item>社員番号:</td>
			<td rowspan="1" class=number>1000${profile.number}</td>

		</tr>
		<tr>
		<td class=item>事業部:</td>
		<td class=department>SI事業部${profile.department}</td>
		</tr>
		<tr>
			<td rowspan="3" class=gender>性別: 女性
			<c:if test="${profile.gender==0}">男性</c:if>
			<c:if test="${profile.gender==1}">女性</c:if>
			</td>
			<td class=item>部:</td>
			<td class=division>金融・保険${profile.divisiont}</td>
		</tr>
		<tr>
			<td>課:</td>
			<td class=section>1課${profile.section}</td>
		</tr>
		<tr>
			<td>役職:</td>
			<td class=post>一般職${profile.post}</td>
		</tr>
		<tr>
		<td class=back_button><a href="/miemo/BControllerServlet?page_id = BP01&bt_name=back_list" class=back>一覧に戻る</a></td>
			<td>入社年度:</td>
			<td class=year>2022${profile.year}年</td>
			<td class=edit_button><input type="submit" name="bt_name" value="編集" class=edit></td>
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
				AAAの内容がここに入ります
			</div>

			<div class="tab_content" id="aaa_content">
				BBBの内容がここに入ります
			</div>

			<div class="tab_content" id="bbb_content">
				CCCの内容がここに入ります
			</div>

			<div class="tab_content" id="ccc_content">
				DDDの内容がここに入ります
			</div>

			<div class="tab_content" id="ddd_content">
				EEEの内容がここに入ります
			</div>
	</div>
</body>
</html>