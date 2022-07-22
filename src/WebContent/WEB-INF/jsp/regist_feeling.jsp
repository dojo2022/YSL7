<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
</head>
<body>
	${errMsg}<br>
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="hidden" name="page_id" value="FF01">
		<table>
		<tr>
			<td>きもち:</td>
			<td>絶不調<input type="checkbox" name="stamp1" value="1" class="check"></td>
			<td>不調<input type="checkbox" name="stamp2" value="1" class="check"></td>
			<td>普通<input type="checkbox" name="stamp3" value="1" class="check"></td>
			<td>好調<input type="checkbox" name="stamp4" value="1" class="check"></td>
			<td>絶好調<input type="checkbox" name="stamp5" value="1" class="check"></td>
		</tr>
		<tr>
			<td>項目　:</td>
			<td>人間関係<input type="radio"  name="category_id" value="1"></td>
			<td>納期<input type="radio"  name="category_id" value="2"></td>
			<td>資格<input type="radio"  name="category_id" value="3"></td>
			<td>残業<input type="radio"  name="category_id" value="4"></td>
			<td>通勤<input type="radio"  name="category_id" value="5"></td>
			<td>職場環境<input type="radio"  name="category_id" value="6"></td>
			<td>睡眠<input type="radio"  name="category_id" value="7"></td>
			<td>家族<input type="radio"  name="category_id" value="8"></td>
			<td>健康<input type="radio"  name="category_id" value="9"></td>
			<td>お金<input type="radio"  name="category_id" value="10"></td>
		</tr>
		</table>
			コメント:<input type="text"  name="comment" value="${param.comment}">
		<input type="submit"  name="bt_name" value="登録">
	</form>

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