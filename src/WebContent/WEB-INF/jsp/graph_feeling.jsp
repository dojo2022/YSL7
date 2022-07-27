<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/miemo/backcss/bStamps.css">
<link rel="stylesheet" href="/miemo/css/common.css">
<link rel="stylesheet" href="/miemo/css/graph_feeling.css">
<title>きもちグラフ</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"></script>
<script  src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>

</head>
<body>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
	<h1 id="midashi">きもちグラフ</h1>
	<div id="gf_chart">
	<h2 class=empName>${user.name}さんのきもちグラフ</h2>
	<!-- スタンプの個数を表示する部分 -->

	<div class="allStamps">
		<div class="asGraph">
			<!--押したスタンプのドーナツチャート -->
			<canvas id="allStamps" width="300" height="200"></canvas>
		</div>
		<div class="asTable">
			<p class="titles">スタンプが押された回数</p>
				<table class="stamp_table" id="stamp_table">
					<tr>
					<!-- 見出し -->
						<th><img alt="とても不満" src="/miemo/img/stamp1.png" class="stamp">とても不満</th>
						<th><img alt="不満" src="/miemo/img/stamp2.png" class="stamp">不満</th>
						<th><img alt="普通" src="/miemo/img/stamp3.png" class="stamp">普通</th>
						<th><img alt="満足" src="/miemo/img/stamp4.png" class="stamp">満足</th>
						<th><img alt="とても満足" src="/miemo/img/stamp5.png" class="stamp">とても満足</th>
					</tr>
					<tr>
						<td>${sCount.countS1}回</td>
						<td>${sCount.countS2}回</td>
						<td>${sCount.countS3}回</td>
						<td>${sCount.countS4}回</td>
						<td>${sCount.countS5}回</td>
					</tr>
				</table>
		</div>

	</div>
	</div>

	<!-- stamp1~stamp5までの円グラフ -->
	<div class="upper">
		<div>
			<span class="titles">とても不満のきもちグラフ</span>
			<div id ="s1ErrMsg"></div>
	 		<canvas id="stamp1" width="250" height="250"></canvas>
	 	</div>
	 	<div>
			<span class="titles">不満のきもちグラフ</span>
			<div id="s2ErrMsg"></div>
			<canvas id="stamp2" width="250" height="250"></canvas>
		</div>
		<div>
			<span class="titles">普通のきもちグラフ</span>
			<div id="s3ErrMsg"></div>
			<canvas id="stamp3" width="250" height="250"></canvas>
		</div>
	</div>
	<div class="lower">
		<div>
			<span class="titles">満足のきもちグラフ</span>
			<div id="s4ErrMsg"></div>
			<canvas id="stamp4" width="250" height="250"></canvas>
		</div>
		<div>
			<span class="titles">とても満足のきもちグラフ</span>
			<div id="s5ErrMsg"></div>
			<canvas id="stamp5" width="250" height="250"></canvas>

		</div>
	</div>

		<script>

		//ドーナツチャートを書くためのjs
		let inputData =${stampPercent};
		let context = document.querySelector('#allStamps').getContext('2d');
		new Chart(context,{
			type: 'doughnut',
			data: {
				//グラフのラベルを設定
				labels: ["とても不満", "不満", "普通", "満足", "とても満足"],
				datasets: [{
					data: [inputData[0], inputData[1],inputData[2],inputData[3],inputData[4],],
					backgroundColor: ['#5674B5', '#92C9FE', '#C8EA69','#FFC14A','#FF944D'],
				}]
			},
			options: {
				responsive: false,
			}
		});

		//stamp1の円グラフ
		if(${s1Percent.size()}>0){
			let inputData1 =${s1Percent};
			//二つ以上グラフを書くときはcontext2,3,4...となんでもいいので名前を変更する
			let context1 = document.querySelector("#stamp1").getContext('2d')
			//上記を変更した場合は、この下の名前（context）も上の名前に合わせる
			new Chart(context1, {
			  type: 'pie',
			  data: {
				  labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
			    datasets: [{
			      //ここで取得した配列の中身を分解して配置する
			      data: [${s1Percent[0]},${s1Percent[1]}, ${s1Percent[2]}, ${s1Percent[3]}, ${s1Percent[4]},${s1Percent[5]},${s1Percent[6]},${s1Percent[7]},${s1Percent[8]},${s1Percent[9]},],
			      backgroundColor: ['#ffbf7f', '#ffff7f', '#bfff7f','#7fff7f','#7fffff','#7fbfff','#ff9a00','#7f7fff','#bf7fff','#ff7f7f'],
			    }]
			  },
			  options: {
			    responsive: false,
			  }
			});
		}else{
			document.querySelector("#s1ErrMsg").innerText ="このスタンプは押されていません。";
		}


		//stamp2の円グラフ
		if(${s2Percent.size()}>0){
			let inputData2 =${s2Percent};
			//二つ以上グラフを書くときはcontext2,3,4...となんでもいいので名前を変更する
			let context2 = document.querySelector("#stamp2").getContext('2d')
			//上記を変更した場合は、この下の名前（context）も上の名前に合わせる
			new Chart(context2, {
			  type: 'pie',
			  data: {
				  labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
			    datasets: [{
			      //ここで取得した配列の中身を分解して配置する
			      data: [${s2Percent[0]},${s2Percent[1]}, ${s2Percent[2]}, ${s2Percent[3]}, ${s2Percent[4]},${s2Percent[5]},${s2Percent[6]},${s2Percent[7]},${s2Percent[8]},${s2Percent[9]},],
			      backgroundColor: ['#ffbf7f', '#ffff7f', '#bfff7f','#7fff7f','#7fffff','#7fbfff','#ff9a00','#7f7fff','#bf7fff','#ff7f7f'],
			    }]
			  },
			  options: {
			    responsive: false,
			  }
			});
		}else{
			document.querySelector("#s2ErrMsg").innerText ="このスタンプは押されていません。";
		}


		//stamp3のグラフ
		if(${s3Percent.size()}>0){
			let inputData3 =${s3Percent};
			//二つ以上グラフを書くときはcontext2,3,4...となんでもいいので名前を変更する
			let context3 = document.querySelector("#stamp3").getContext('2d')
			//上記を変更した場合は、この下の名前（context）も上の名前に合わせる
			new Chart(context3, {
			  type: 'pie',
			  data: {
				  labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
			    datasets: [{
			      //ここで取得した配列の中身を分解して配置する
			      data: [${s3Percent[0]},${s3Percent[1]}, ${s3Percent[2]}, ${s3Percent[3]}, ${s3Percent[4]},${s3Percent[5]},${s3Percent[6]},${s3Percent[7]},${s3Percent[8]},${s3Percent[9]},],
			      backgroundColor: ['#ffbf7f', '#ffff7f', '#bfff7f','#7fff7f','#7fffff','#7fbfff','#ff9a00','#7f7fff','#bf7fff','#ff7f7f'],
			    }]
			  },
			  options: {
			    responsive: false,
			  }
			});
		}else{
			document.querySelector("#s3ErrMsg").innerText ="このスタンプは押されていません。";
		}

		//stamp4の円グラフ
		if(${s4Percent.size()}>0){
			let inputData4 =${s4Percent};
			//二つ以上グラフを書くときはcontext2,3,4...となんでもいいので名前を変更する
			let context4 = document.querySelector("#stamp4").getContext('2d')
			//上記を変更した場合は、この下の名前（context）も上の名前に合わせる
			new Chart(context4, {
			  type: 'pie',
			  data: {
				  labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
			    datasets: [{
			      //ここで取得した配列の中身を分解して配置する
			      data: [${s4Percent[0]},${s4Percent[1]}, ${s4Percent[2]}, ${s4Percent[3]}, ${s4Percent[4]},${s4Percent[5]},${s4Percent[6]},${s4Percent[7]},${s4Percent[8]},${s4Percent[9]},],
			      backgroundColor: ['#ffbf7f', '#ffff7f', '#bfff7f','#7fff7f','#7fffff','#7fbfff','#ff9a00','#7f7fff','#bf7fff','#ff7f7f'],
			    }]
			  },
			  options: {
			    responsive: false,
			  }
			});
		}else{
			document.querySelector("#s4ErrMsg").innerText ="このスタンプは押されていません。";
		}

		//stampp5の円グラフ
		if(${s5Percent.size()}>0){
			let inputData5 =${s5Percent};
			//二つ以上グラフを書くときはcontext2,3,4...となんでもいいので名前を変更する
			let context5 = document.querySelector("#stamp5").getContext('2d')
			//上記を変更した場合は、この下の名前（context）も上の名前に合わせる
			new Chart(context5, {
			  type: 'pie',
			  data: {
				  labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
			    datasets: [{
			      //ここで取得した配列の中身を分解して配置する
			      data: [${s5Percent[0]},${s5Percent[1]}, ${s5Percent[2]}, ${s5Percent[3]}, ${s5Percent[4]},${s5Percent[5]},${s5Percent[6]},${s5Percent[7]},${s5Percent[8]},${s5Percent[9]},],
			      backgroundColor: ['#ffbf7f', '#ffff7f', '#bfff7f','#7fff7f','#7fffff','#7fbfff','#ff9a00','#7f7fff','#bf7fff','#ff7f7f'],
			    }]
			  },
			  options: {
			    responsive: false,
			  }
			});
		}else{
			document.querySelector("#s5ErrMsg").innerText ="このスタンプは押されていません。";
		}


		</script>
</body>
</html>