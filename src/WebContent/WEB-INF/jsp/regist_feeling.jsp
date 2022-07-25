<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>きもち記録</title>
<link rel = "stylesheet" href = "/miemo/css/regist_feeling.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
</head>
<body>
<h2>きもち記録</h2>
	${errMsg}<br>
	<div class="regist_fe_tb">
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="hidden" name="page_id" value="FF01">
		<table>
		<tr>
			<td>きもち:
				<input type="checkbox" name="stamp1" value="1" class="check" id="stamp1">
				<label for="stamp1" class="stamp_label">
					<img src="/miemo/img/stamp1.png" width="40px" class="stamp_img">
				</label>

				<input type="checkbox" name="stamp2" value="1" class="check" id="stamp2">
				<label for="stamp2" class="stamp_label">
					<img src="/miemo/img/stamp2.png" width="40px" class="stamp_img">
				</label>

				<input type="checkbox" name="stamp3" value="1" class="check" id="stamp3">
				<label for="stamp3" class="stamp_label">
					<img src="/miemo/img/stamp3.png" width="40px" class="stamp_img">
				</label>

				<input type="checkbox" name="stamp4" value="1" class="check" id="stamp4">
				<label for="stamp4" class="stamp_label">
					<img src="/miemo/img/stamp4.png" width="40px" class="stamp_img">
				</label>

				<input type="checkbox" name="stamp5" value="1" class="check" id="stamp5">
				<label for="stamp5" class="stamp_label">
					<img src="/miemo/img/stamp5.png" width="40px" class="stamp_img">
				</label>
			</td>
		</tr>
		<tr>
			<td>項目:
				人間関係<input type="radio"  name="category_id" value="1">
				納期<input type="radio"  name="category_id" value="2">
				資格<input type="radio"  name="category_id" value="3">
				残業<input type="radio"  name="category_id" value="4">
				通勤<input type="radio"  name="category_id" value="5">
				職場環境<input type="radio"  name="category_id" value="6">
				睡眠<input type="radio"  name="category_id" value="7">
				家族<input type="radio"  name="category_id" value="8">
				健康<input type="radio"  name="category_id" value="9">
				お金<input type="radio"  name="category_id" value="10">
			</td>
		</tr>
		</table>
			コメント:<input type="text"  name="comment" value="${param.comment}">
		<input type="submit"  name="bt_name" value="登録">
	</form>
	</div>

</body>
<script>
$(function(){
	  $('.check').on('click', function() {
	    if ($(this).prop('checked')){
	      // 一旦全てをクリアして再チェックする
	      $('.check').prop('checked', false);
	      $(this).prop('checked', true);
	    }
	  });
	});
</script>
</html>