<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
<script src="/WebContent/backjs/bStampsGraph.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.min.js"></script>
<script  src="https://cdn.jsdelivr.net/npm/chartjs-adapter-date-fns@next/dist/chartjs-adapter-date-fns.bundle.min.js"></script>
<link rel="stylesheet" href="/miemo/backcss/bEvaluations.css">
</head>

<body>
<div class="tab">
 <table class="evaList">
	<tr class="eva_items">
		<th class="eva_items">評価項目</th>
		<th class="eva_items1">自己評価</th>
		<th class="eva_items1">他者評価</th>
	</tr>
	<tr class="eva_data">
		<td class="eva_data">職場内の人間関係にストレスを感じていない</td>
 		<td class="eva_data">${myEvaluation.eva1}</td>
		<td class="eva_data">${avg[0]}</td>
	</tr>
		<tr class="eva_data">
		<td class="eva_data">業務に意欲的に取り組んでいる</td>
		<td class="eva_data">${myEvaluation.eva2}</td>
		<td class="eva_data">${avg[1]}</td>
	</tr>
		<tr class="eva_data">
		<td class="eva_data">報告・連絡・相談が適切にできている</td>
		<td class="eva_data">${myEvaluation.eva3}</td>
		<td class="eva_data">${avg[2]}</td>
	</tr>
	<tr class="eva_data">
		<td class="eva_data">業務に必要な技術や知識を発揮できている</td>
		<td class="eva_data">${myEvaluation.eva4}</td>
		<td class="eva_data">${avg[3]}</td>
	</tr>
		<tr class="eva_data">
		<td class="eva_data">タスク量と期限は適切である</td>
		<td class="eva_data">${myEvaluation.eva5}</td>
		<td class="eva_data">${avg[4]}</td>
	</tr>
</table>

<!-- レーダーチャート -->
<div class=radar_graph>
<canvas id="evaluationChart" width="600" height="400"></canvas>
<script>


let context10 = document.querySelector("#evaluationChart").getContext('2d');

new Chart(context10, {
	type:'radar',
	data: {
		labels: [
			"職場内の人間関係にストレスを感じていない",
			"業務に意欲的に取り組んでいる",
			"報告・連絡・相談が適切にできている",
			"業務に必要な技術や知識を発揮できている",
			"タスク量と期限は適切である"
		],
		datasets: [{
			label:'自己評価',
			data:[
				${myEvaluation.eva1},
				${myEvaluation.eva2},
				${myEvaluation.eva3},
				${myEvaluation.eva4},
				${myEvaluation.eva5}
			],
			backgroundColor: 'RGBA(0,0,0,0)',
			borderColor: '#00C2CB',
            borderWidth: 1,
            pointBackgroundColor: '#00C2CB'
		},{
			label:'他者評価',
			data:[
				${avg[0]},
				${avg[1]},
				${avg[2]},
				${avg[3]},
				${avg[4]}
			],
			backgroundColor: 'RGBA(0,0,0,0)',
            borderColor: '#CB6CE6',
            borderWidth: 1,
            pointBackgroundColor: '#CB6CE6'
		}]
	},
	options: {
		responsive: false,
	}
});
</script>
</div>
</div>
</body>
</html>