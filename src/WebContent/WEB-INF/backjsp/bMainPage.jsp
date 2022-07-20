<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 /*タブ切り替え全体のスタイル*/
.tabs {
	margin-top: 50px;
	padding-bottom: 40px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	width: 700px;
	margin: 0 auto;
}

/*タブのスタイル*/
.tab_item {
	width: calc(100%/ 3);
	height: 50px;
	border-bottom: 3px solid #5ab4bd;
	background-color: #d9d9d9;
	line-height: 50px;
	font-size: 16px;
	text-align: center;
	color: #565656;
	display: block;
	float: left;
	text-align: center;
	font-weight: bold;
	transition: all 0.2s ease;
}

.tab_item:hover {
	opacity: 0.75;
}

/*ラジオボタンを全て消す*/
input[name="tab_item"] {
	display: none;
}

/*タブ切り替えの中身のスタイル*/
.tab_content {
	display: none;
	padding: 40px 40px 0;
	clear: both;
	overflow: hidden;
}

/*選択されているタブのコンテンツのみを表示*/
#all:checked ~ #all_content, #aaa:checked ~ #aaa_content,
	#bbb:checked ~ #bbb_content {
	display: block;
}

/*選択されているタブのスタイルを変える*/
.tabs input:checked+.tab_item {
	background-color: #5ab4bd;
	color: #fff;
}

</style>
</head>
<body>

	<div class="tabs">
		<input id="all" type="radio" name="tab_item" checked>
		<!-- ここからタブ -->
			<label class="tab_item" for="all">AAA</label>
			<input id="aaa" type="radio" name="tab_item">

			<label class="tab_item"	for="aaa">BBB</label>
			<input id="bbb" type="radio"	name="tab_item">

			<label class="tab_item" for="bbb">CCC</label>

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
	</div>
</body>
</html>