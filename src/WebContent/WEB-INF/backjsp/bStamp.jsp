<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/miemo/backcss/bStamps.css">
<title>きもちグラフ | miemo</title>
</head>
<body>
	<table>
		<tr>
			<!-- テーブルの見出し -->
			<th class="data">日付</th>
			<th class="data">スタンプ</th>
			<th class="data">カテゴリ</th>
			<th class="content">内容</th>
		</tr>
		<tr>
			<td class="data">2022/07/22</td>
			<td class="data">満足</td>
			<td class="data">お金</td>
			<td>恥の多い生涯を送って来ました。自分には、人間の生活というものが、見当つかないのです。自分は東北の田舎に生れましたので、汽車をはじめて見たのは、よほど大きくなってからでした。自分は停車場のブリッジを、上って、降りて、そうしてそれが線路をまたぎ越えるために造られたものだという事には全然気づかず、ただそれは停車場の構内を外国の遊戯場みたいに、複雑に楽しく、ハイカラにするためにのみ、設備せられてあるものだとばかり思っていました。しかも、かなり永い間そう思っていたのです。ブリッジの上ったり降りたりは、自分にはむしろ、ずいぶん垢抜けのした遊戯で、それは鉄道のサーヴィスの中でも、最も気のきいたサーヴィスの一つだと思っていたのですが、</td>
		</tr>
 		<c:forEach var="e" items="${allStamps}">
		<tr>
			<!-- 日付のセル -->
			<td class="data">${e.date}</td>
			<!-- スタンプのセル -->
			<td class="data">
				<c:if test="${e.stamp1 == 1}"><img src=""></c:if>
				<c:if test="${e.stamp2 == 1}"><img src=""></c:if>
				<c:if test="${e.stamp3 == 1}"><img src=""></c:if>
				<c:if test="${e.stamp4 == 1}"><img src=""></c:if>
				<c:if test="${e.stamp5 == 1}"><img src=""></c:if>
			</td>
			<!-- カテゴリのセル -->
			<td class="data">${e.category}</td>
			<!-- コメントのセル -->
			<td>${e.comment}</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>