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
			<td><div class="font">きもち</div>
				<span class="stamp_span">
					<input type="checkbox" name="stamp1" value="1" class="check" id="stamp1">
					<label for="stamp1" class="stamp_label">
						<img src="/miemo/img/stamp1.png" width="40px" class="stamp_img">
					</label>
				</span>
				<span class="stamp_span">
					<input type="checkbox" name="stamp2" value="1" class="check" id="stamp2">
					<label for="stamp2" class="stamp_label">
						<img src="/miemo/img/stamp2.png" width="40px" class="stamp_img">
					</label>
				</span>
				<span class="stamp_span">
					<input type="checkbox" name="stamp3" value="1" class="check" id="stamp3">
					<label for="stamp3" class="stamp_label">
						<img src="/miemo/img/stamp3.png" width="40px" class="stamp_img">
					</label>
				</span>
				<span class="stamp_span">
					<input type="checkbox" name="stamp4" value="1" class="check" id="stamp4">
					<label for="stamp4" class="stamp_label">
						<img src="/miemo/img/stamp4.png" width="40px" class="stamp_img">
					</label>
				</span>
				<span class="stamp_span">
					<input type="checkbox" name="stamp5" value="1" class="check" id="stamp5">
					<label for="stamp5" class="stamp_label">
						<img src="/miemo/img/stamp5.png" width="40px" class="stamp_img">
					</label>
				</span>
			</td>
		</tr>
		<tr>
			<td><div class="font">項目</div>
				<input type="radio"  name="category_id" value="1" id="c_1" class="radio_bt">
				<label for="c_1">
					<span class="c_span">人間関係</span>
				</label>
				<input type="radio"  name="category_id" value="2" id="c_2" class="radio_bt">
				<label for="c_2">
					<span class="c_span">納期</span>
				</label>
				<input type="radio"  name="category_id" value="3" id="c_3" class="radio_bt">
				<label for="c_3">
					<span class="c_span">資格</span>
				</label>
				<input type="radio"  name="category_id" value="4" id="c_4" class="radio_bt">
				<label for="c_4">
					<span class="c_span">残業</span>
				</label>
				<input type="radio"  name="category_id" value="5" id="c_5" class="radio_bt">
				<label for="c_5">
					<span class="c_span">通勤</span>
				</label>
				<input type="radio"  name="category_id" value="6" id="c_6" class="radio_bt">
				<label for="c_6">
					<span class="c_span">職場環境</span>
				</label>
				<input type="radio"  name="category_id" value="7" id="c_7" class="radio_bt">
				<label for="c_7">
					<span class="c_span">睡眠</span>
				</label>
				<input type="radio"  name="category_id" value="8" id="c_8" class="radio_bt">
				<label for="c_8">
					<span class="c_span">家族</span>
				</label>
				<input type="radio"  name="category_id" value="9" id="c_9" class="radio_bt">
				<label for="c_9">
					<span class="c_span">健康</span>
				</label>
				<input type="radio"  name="category_id" value="10" id="c_10" class="radio_bt">
				<label for="c_10">
					<span class="c_span">お金</span>
				</label>
			</td>
		</tr>
		<tr>
			<td><div class="font">コメント</div>
				<textarea  name="comment" class="textarea">${param.comment}</textarea>
			</td>
		</tr>
		</table>
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