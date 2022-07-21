<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<table>
	<tr>
		<th>評価項目</th>
		<th>自己評価</th>
		<th>他者評価</th>
	</tr>
	<tr>
		<td>職場内の人間関係にストレスを感じていない</td>
		<td>${myEvaluationList.eva1}</td>
		<td>${otherEvaluationList.eva1}</td>
	</tr>
		<tr>
		<td>業務に意欲的に取り組んでいる</td>
		<td>${myEvaluationList.eva2}</td>
		<td>${otherEvaluationList.eva2}</td>
	</tr>
		<tr>
		<td>報告・連絡・相談が適切にできている</td>
		<td>${myEvaluationList.eva3}</td>
		<td>${otherEvaluationList.eva3}</td>
	</tr>
		<tr>
		<td>業務に必要な技術や知識を発揮できている</td>
		<td>${myEvaluationList.eva4}</td>
		<td>${otherEvaluationList.eva4}</td>
	</tr>
		<tr>
		<td>タスク量と期限は適切である</td>
		<td>${myEvaluationList.eva5}</td>
		<td>${otherEvaluationList.eva5}</td>
	</tr>
</table>

<!-- レーダーチャート -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
<canvas id="evaluationChart"></canvas>
<script>
let inputData =${myEvaluationList},${otherEvaluationList};
let context = document.querySelector("#evaluationChart").getContext('2d')
new Chart(context, {
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
				${myEvaluationList.eva1},
				${myEvaluationList.eva2},
				${myEvaluationList.eva3},
				${myEvaluationList.eva4},
				${myEvaluationList.eva5}
			],
			borderColor: 'RGBA(115,255,25, 1)',
            borderWidth: 1,
            pointBackgroundColor: 'RGB(46,106,177)'
		},{
			label:'他者評価',
			data:[
				${otherEvaluationList.eva1},
				${otherEvaluationList.eva2},
				${otherEvaluationList.eva3},
				${otherEvaluationList.eva4},
				${otherEvaluationList.eva5}
			],
            borderColor: 'RGBA(225,95,150, 1)',
            borderWidth: 1,
            pointBackgroundColor: 'RGB(46,106,177)'
		}]
	}
}
</script>
</body>
</html>