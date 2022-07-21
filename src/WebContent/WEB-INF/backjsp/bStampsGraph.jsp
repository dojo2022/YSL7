<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>きもちグラフ | miemo</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="/WebContent/backjs/bStampsGraph.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"></script>
<script  src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>

</head>
<body>
	<!-- スタンプの個数を表示する部分 -->
	<table border="1">
		<tr>
		<!-- 見出し -->
			<th><img alt="とても不満" src=""></th>
			<th><img alt="不満" src=""></th>
			<th><img alt="普通" src=""></th>
			<th><img alt="満足" src=""></th>
			<th><img alt="とても満足" src=""></th>
		</tr>
		<tr>
			<td>${countAllStamps.countS1}</td>
			<td>${countAllStamps.countS2}</td>
			<td>${countAllStamps.countS3}</td>
			<td>${countAllStamps.countS4}</td>
			<td>${countAllStamps.countS5}</td>
		</tr>
	</table>
	<!--押したスタンプのドーナツチャート -->
	<canvas id="allStamps" width="600" height="500"></canvas>
	<!-- stamp1~stamp5までの円グラフ -->
	<canvas id="stamp1" width="250" height="250"></canvas>
	<canvas id="stamp2" width="250" height="250"></canvas>
	<canvas id="stamp3" width="250" height="250"></canvas>
	<canvas id="stamp4" width="250" height="250"></canvas>
	<canvas id="stamp5" width="250" height="250"></canvas>

		<script>
		//ドーナツチャートを書くためのjs
		let inputData =${stampPercent};
		let context = document.querySelector('#allStamps').getContext('2d');
		new Chart(context,{
			type: 'doughnut',
			data: {
				//グラフのラベルを設定
				labels: ["にっこり", "ちょっとにっこり", "普通", "ちょっと不満", "不満"],
				datasets: [{
					data: [inputData[4], inputData[3],inputData[2],inputData[1],inputData[0],],
					backgroundColor: ['#7fffd4', '#87cefa', '#f5deb3','#ff69b4','#dc143c'],
				}]
			},
			options: {
				responsive: false,
			}
		});
		//stamp1の円グラフ
		let inputData1 =${s1Percent};
		let context1 = documet.querySelector("#stamp1").getContext('2d');
		new Chart(context1, {
			type: 'pie',
			data: {
				labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
				datasets: [{
					data: [inputData1[0], inputData1[1], inputData1[2], inputData1[3], inputData1[4], inputData1[5],inputData1[6],inputData1[7],inputData1[8],inputData1[9],],
					backgroundColor: ['#87cefa', '#7cfc00', '#d2691e','#dda0dd','#ffebcd'],
				}]
			},
			options: {
				responsive: false,
			}
		});
		//stamp2の円グラフ
		let inputData2 =${s2Percent};
		let context2 = documet.querySelector("#stamp2").getContext('2d');
		new Chart(context2, {
			type: 'pie',
			data: {
				labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
				datasets: [{
					data: [inputData2[0], inputData2[1], inputData2[2], inputData2[3], inputData2[4], inputData2[5],inputData2[6],inputData2[7],inputData2[8],inputData2[9],],
					backgroundColor: ['#87cefa', '#7cfc00', '#d2691e','#dda0dd','#ffebcd'],
				}]
			},
			options: {
				responsive: false,
			}
		});
		//stamp3の円グラフ
		let inputData3 =${s3Percent};
		let context3 = documet.querySelector("#stamp3").getContext('2d');
		new Chart(context3, {
			type: 'pie',
			data: {
				labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
				datasets: [{
					data: [inputData3[0], inputData3[1], inputData3[2], inputData3[3], inputData3[4], inputData3[5],inputData3[6],inputData3[7],inputData3[8],inputData3[9],],
					backgroundColor: ['#87cefa', '#7cfc00', '#d2691e','#dda0dd','#ffebcd'],
				}]
			},
			options: {
				responsive: false,
			}
		});
		//stamp4の円グラフ
		let inputData4 =${s4Percent};
		let context4 = documet.querySelector("#stamp4").getContext('2d');
		new Chart(context4, {
			type: 'pie',
			data: {
				labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
				datasets: [{
					data: [inputData4[0], inputData4[1], inputData4[2], inputData4[3], inputData4[4], inputData4[5],inputData4[6],inputData4[7],inputData4[8],inputData4[9],],
					backgroundColor: ['#87cefa', '#7cfc00', '#d2691e','#dda0dd','#ffebcd'],
				}]
			},
			options: {
				responsive: false,
			}
		});
		//stamp5の円グラフ
		let inputData5 =${s5Percent};
		let context5 = documet.querySelector("#stamp5").getContext('2d');
		new Chart(context5, {
			type: 'pie',
			data: {
				labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
				datasets: [{
					data: [inputData5[0], inputData5[1], inputData5[2], inputData5[3], inputData5[4], inputData5[5],inputData5[6],inputData5[7],inputData5[8],inputData5[9],],
					backgroundColor: ['#87cefa', '#7cfc00', '#d2691e','#dda0dd','#ffebcd'],
				}]
			},
			options: {
				responsive: false,
			}
		});

		</script>
</body>
</html>