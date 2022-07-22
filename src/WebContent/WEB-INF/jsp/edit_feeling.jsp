<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
</head>
<body>
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="hidden" name="page_id" value="FF03">
		<input type="hidden" name="stamp_id" value="${param.stamp_id }">
		<c:choose>
			<c:when test="${param.stamp1 == 1 }">
				絶不調<input type="checkbox" name="stamp1" value="1" checked class="check">
			</c:when>
			<c:otherwise>
				絶不調<input type="checkbox" name="stamp1" value="1" class="check">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.stamp2 == 1 }">
				不調<input type="checkbox" name="stamp2" value="1" checked class="check">
			</c:when>
			<c:otherwise>
				不調<input type="checkbox" name="stamp2" value="1" class="check">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.stamp3 == 1 }">
				普通<input type="checkbox" name="stamp3" value="1" checked class="check">
			</c:when>
			<c:otherwise>
				普通<input type="checkbox" name="stamp3" value="1" class="check">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.stamp4 == 1 }">
				好調<input type="checkbox" name="stamp4" value="1" checked class="check">
			</c:when>
			<c:otherwise>
				好調<input type="checkbox" name="stamp4" value="1" class="check">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.stamp5 == 1 }">
				絶好調<input type="checkbox" name="stamp5" value="1" checked class="check">
			</c:when>
			<c:otherwise>
				絶好調<input type="checkbox" name="stamp5" value="1" class="check"><br>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${param.category_id == 1 }">
				人間関係<input type="radio"  name="category_id" value="1" checked>
			</c:when>
			<c:otherwise>
				人間関係<input type="radio"  name="category_id" value="1">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 2 }">
				納期<input type="radio"  name="category_id" value="2" checked>
			</c:when>
			<c:otherwise>
				納期<input type="radio"  name="category_id" value="2">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 3 }">
				資格<input type="radio"  name="category_id" value="3" checked>
			</c:when>
			<c:otherwise>
				資格<input type="radio"  name="category_id" value="3">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 4 }">
				残業<input type="radio"  name="category_id" value="4" checked>
			</c:when>
			<c:otherwise>
				残業<input type="radio"  name="category_id" value="4">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 5 }">
				通勤<input type="radio"  name="category_id" value="5" checked>
			</c:when>
			<c:otherwise>
				通勤<input type="radio"  name="category_id" value="5">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 6 }">
				職場環境<input type="radio"  name="category_id" value="6" checked>
			</c:when>
			<c:otherwise>
				職場環境<input type="radio"  name="category_id" value="6">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 7 }">
				睡眠<input type="radio"  name="category_id" value="7" checked>
			</c:when>
			<c:otherwise>
				睡眠<input type="radio"  name="category_id" value="7">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 8 }">
				家族<input type="radio"  name="category_id" value="8" checked>
			</c:when>
			<c:otherwise>
				家族<input type="radio"  name="category_id" value="8">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 9 }">
				健康<input type="radio"  name="category_id" value="9" checked>
			</c:when>
			<c:otherwise>
				健康<input type="radio"  name="category_id" value="9">
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${param.category_id == 10 }">
				お金<input type="radio"  name="category_id" value="10" checked>
			</c:when>
			<c:otherwise>
				お金<input type="radio"  name="category_id" value="10">
			</c:otherwise>
		</c:choose>
		<input type="text"  name="comment" value="${param.comment}">
		<input type="submit"  name="bt_name" value="更新">
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