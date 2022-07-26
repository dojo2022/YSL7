<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "/miemo/css/common.css">
<link rel = "stylesheet" href = "/miemo/css/graph_feeling.css">

<title>きもちグラフ | miemo</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"></script>
<script  src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>
<link rel = "stylesheet" href = "/miemo/backcss/bStamps.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
	<!-- スタンプの個数を表示する部分 -->
	<main>
	<table class="stamp_table">
		<tr>
		<!-- 見出し -->
			<th><img alt="とても不満" src="/miemo/img/stamp1.png" class="stamp">とても不満</th>
			<th><img alt="不満" src="/miemo/img/stamp2.png" class="stamp">不満</th>
			<th><img alt="普通" src="/miemo/img/stamp3.png" class="stamp">普通</th>
			<th><img alt="満足" src="/miemo/img/stamp4.png" class="stamp">満足</th>
			<th><img alt="とても満足" src="/miemo/img/stamp5.png" class="stamp">とても満足</th>
		</tr>
		<tr>
			<td>${sCount.countS1}</td>
			<td>${sCount.countS2}</td>
			<td>${sCount.countS3}</td>
			<td>${sCount.countS4}</td>
			<td>${sCount.countS5}</td>
		</tr>
	</table>
	<!--押したスタンプのドーナツチャート -->
	<canvas id="allStamps" width="600" height="500"></canvas>
	<!-- stamp1~stamp5までの円グラフ -->
	とても不満のきもちグラフ
	<canvas id="stamp1" width="250" height="250"></canvas>
	不満のきもちグラフ
	<canvas id="stamp2" width="250" height="250"></canvas>
	普通のきもちグラフ
	<canvas id="stamp3" width="250" height="250"></canvas>
	満足のきもちグラフ
	<canvas id="stamp4" width="250" height="250"></canvas>
	とても満足のきもちグラフ
	<canvas id="stamp5" width="250" height="250"></canvas>
	</main>
		<script>
		//ドーナツチャートを書くためのjs
		let inputData =${stampPercent};
		let context = document.querySelector('#allStamps').getContext('2d');
		new Chart(context,{
			type: 'doughnut',
			data: {
				//グラフのラベルを設定
				labels: ["とても満足", "満足", "普通", "不満", "とても不満"],
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
		      backgroundColor: ['#87CEFA', '#7CFC00', '#D2691E','#DDA0DD','#FFEBCD'],
		    }]
		  },
		  options: {
		    responsive: false,
		  }
		});

		//stamp2の円グラフ
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
		      backgroundColor: ['#87CEFA', '#7CFC00', '#D2691E','#DDA0DD','#FFEBCD'],
		    }]
		  },
		  options: {
		    responsive: false,
		  }
		});

		//stamp3のグラフ
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
		      backgroundColor: ['#87CEFA', '#7CFC00', '#D2691E','#DDA0DD','#FFEBCD'],
		    }]
		  },
		  options: {
		    responsive: false,
		  }
		});

		//stamp4の円グラフ
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
		      backgroundColor: ['#87CEFA', '#7CFC00', '#D2691E','#DDA0DD','#FFEBCD'],
		    }]
		  },
		  options: {
		    responsive: false,
		  }
		});

		//stampp5の円グラフ
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
		      backgroundColor: ['#87CEFA', '#7CFC00', '#D2691E','#DDA0DD','#FFEBCD'],
		    }]
		  },
		  options: {
		    responsive: false,
		  }
		});

/*
		//stamp2の円グラフ
		let inputData2 =${s2Percent};
		let context2 = documet.querySelector("#stamp2").getContext('2d');
		new Chart(context2, {
			type: 'pie',
			data: {
				labels: ['人間関係','納期','資格','残業', '通勤','職場環境','睡眠','家族','健康','お金'],
				datasets: [{
					data: [${s2Percent[0]}, ${s2Percent[1]}, ${s2Percent[2]}, ${s2Percent[3]}, ${s2Percent[4]}, ${s2Percent[5]},${s2Percent[6]}],${s2Percent[7]},${s2Percent[8]},${s2Percent[9]}],
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
					data: [${s3Percent[0]}, ${s3Percent[1]}, ${s3Percent[2]}, ${s3Percent[3]}, ${s3Percent[4]}, ${s3Percent[5]},${s3Percent[6]}],${s3Percent[7]},${s3Percent[8]},${s3Percent[9]}],
					backgroundColor: ['#87cefa', '#7cfc00', '#d2691e','#dda0dd','#ffebcd'],
				}]
			},
			options: {
				responsive: false,
			}
		}); */
/*		//stamp4の円グラフ
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
 */
		</script>
</body>
</html>