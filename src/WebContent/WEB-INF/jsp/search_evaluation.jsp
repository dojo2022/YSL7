<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テーブルソート</title>
<!-- ファイル読み込み--------------------------- -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/css/theme.default.min.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/js/jquery.tablesorter.widgets.min.js"></script>

<!-- スタイルの適用--------------------------- -->
<style type="text/css">
#myTable .tablesorter-header {
	cursor: pointer;
	outline: none;
}
#myTable .tablesorter-header-inner::after {
	content: '▼';
	font-size: 12px;
	margin-left: 5px;
}
</style>

<!-- javascript--------------------------- -->
<script>
//ページを読み込み後に、ソートを開始
$(document).ready(function(){
	        $("#myTable").tablesorter();
});
</script>
<body>
</head>
<!-- テーブル本体------------------------------------------------------ -->
<!-- テーブルにidとclassをしっかりと書く -->
<table id="myTable" class="tablesorter">
    <!-- theadとtbodyは必ず必要 -->
	<thead>
		<tr>
			<th>番号</th>
			<th>ID</th>
			<th>名前</th>
			<th>名前（かな）</th>
			<th>誕生日</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>2</td>
			<td>bbb</td>
			<td>田中</td>
			<td>たなか</td>
			<td>3/24</td>
		</tr>
		<tr>
			<td>5</td>
			<td>dud</td>
			<td>青木</td>
			<td>あおき</td>
			<td>5/9</td>
		</tr>
		<tr>
			<td>1</td>
			<td>ake</td>
			<td>佐藤</td>
			<td>さとう</td>
			<td>1/21</td>
		</tr>
		<tr>
			<td>3</td>
			<td>clw</td>
			<td>山田</td>
			<td>やまだ</td>
			<td>2/4</td>
		</tr>
		<tr>
			<td>4</td>
			<td>eru</td>
			<td>森</td>
			<td>もり</td>
			<td>4/16</td>
		</tr>
	</tbody>
</table>

<div class=box>
<h1>評価する相手を検索してください。</h1>



<!-- サーブレットへ遷移させる -->
<form method="POST" action="/miemo/action/SearchEvaluationAction">
	<input type ="hidden" name="page_id" value="FE01">

	<!-- 検索のテキストボックス -->
	検索<input type="text" name="" value="${param.name}">

	<!-- 評価するボタン -->>
	<input type ="submit" name ="bt_name" value="評価する">

</form>
</div>
</body>
</html>