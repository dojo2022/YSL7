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

</head>
<link rel="stylesheet" href="/miemo/backcss/bEvaluations.css">
<body>
<div class="tab">
 <table id="evaList">
	<tr class="eva_items">
		<th>評価項目</th>
		<th>自己評価</th>
		<th>他者評価</th>
	</tr>
	<tr class="eva_data">
		<td>職場内の人間関係にストレスを感じていない</td>
 		<td>${myEvaluation.eva1}</td>
		<td>${avg[0]}</td>
	</tr>
		<tr class="eva_data">
		<td>業務に意欲的に取り組んでいる</td>
		<td>${myEvaluation.eva2}</td>
		<td>${avg[1]}</td>
	</tr>
		<tr class="eva_data">
		<td>報告・連絡・相談が適切にできている</td>
		<td>${myEvaluation.eva3}</td>
		<td>${avg[2]}</td>
	</tr>
	<tr class="eva_data">
		<td>業務に必要な技術や知識を発揮できている</td>
		<td>${myEvaluation.eva4}</td>
		<td>${avg[3]}</td>
	</tr>
		<tr class="eva_data">
		<td>タスク量と期限は適切である</td>
		<td>${myEvaluation.eva5}</td>
		<td>${avg[4]}</td>
	</tr>
</table>

<!-- レーダーチャート -->

<canvas id="evaluationChart"></canvas>
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
			borderColor: 'RGBA(115,255,25, 1)',
            borderWidth: 1,
            pointBackgroundColor: 'RGB(46,106,177)'
		},{
			label:'他者評価',
			data:[
				${avg[0]},
				${avg[1]},
				${avg[2]},
				${avg[3]},
				${avg[4]}
			],
            borderColor: 'RGBA(225,95,150, 1)',
            borderWidth: 1,
            pointBackgroundColor: 'RGB(46,106,177)'
		}]
	}
});
</script>
</div>
</body>
</html>