<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

 <link rel = "stylesheet" href = "/miemo/css/evaluation.css">
 <link rel="stylesheet" type="text/css" href="/miemo/css/common.css">
 <link rel="stylesheet" href="https://cdn.datatables.net/t/bs-3.3.6/jqc-1.12.0,dt-1.10.11/datatables.min.css"/>




<meta charset="UTF-8">
<title>評価シート画面</title>
<style>
	.stars span{
	  display: flex;               /* 要素をフレックスボックスにする */
	  flex-direction: row-reverse; /* 星を逆順に並べる */
	  justify-content: flex-end;   /* 逆順なので、左寄せにする */
	}

	.stars input[type='radio']{
	  display: none;               /* デフォルトのラジオボタンを非表示にする */
	}

	.stars label{
	  color: #D2D2D2;              /* 未選択の星をグレー色に指定 */
	  font-size: 30px;             /* 星の大きさを30pxに指定 */
	  padding: 0 5px;              /* 左右の余白を5pxに指定 */
	  cursor: pointer;             /* カーソルが上に乗ったときに指の形にする */
	}

	.stars label:hover,
	.stars label:hover ~ label,
	.stars input[type='radio']:checked ~ label{
	  color: #F8C601;              /* 選択された星以降をすべて黄色にする */
	}

</style>
</head>
<body>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<h1 id="midashi">評価シート</h1>
<br>
<main>
<link rel="stylesheet" type="text/css" href="/miemo/css/common.css">
	<!-- サーブレットへ遷移させる -->
	<form method="POST" action="/miemo/FrontControllerServlet">
		<input type="hidden" name="page_id" value="FE02">



	<!-- 評価先選択画面に戻るボタン -->
	<div class="button_area">
		<a href="/miemo/FrontControllerServlet?page_id=FE02&bt_name=evaluation">評価相手選択画面に戻る</a>
	</div><br>
	<!-- 評価相手の名前を表示 -->
			<input type="hidden" name="user_id" value="${param.user_id }">
			<input type="hidden" name="evaluate_name" value="${param.evaluate_name}">
			<p id="toname">To:${param.evaluate_name}</p><br>
		<%-- <c:if test="${param.evaluate_name == null }">
			<input type="text" name="evaluate_name2" value="${u.userId }">
			<p id="toname">To:${u.name}</p><br>
		</c:if> --%>

	<!-- ★評価 -->
	<div class="stars">
		<span>
			<table border="1" id="stars_table">
				<tr>
					<th>質問1：職場内の人間関係にストレスを感じていない</th>
					<td>
						<div class="review">
					  		<div class="stars">
							    <span>
							      <input id="1review01" type="radio" name="evaluate1" value="5"><label for="1review01">　★</label>
							      <input id="1review02" type="radio" name="evaluate1" value="4"><label for="1review02">　★</label>
							      <input id="1review03" type="radio" name="evaluate1" value="3"><label for="1review03">　★</label>
							      <input id="1review04" type="radio" name="evaluate1" value="2"><label for="1review04">　★</label>
							      <input id="1review05" type="radio" name="evaluate1" value="1"><label for="1review05">★</label>
							    </span>
					 		 </div>
						</div>
					</td>
				</tr>
				<tr>
					<th>質問2：業務に意欲的に取り組んでいる</th>
					<td>
						<div class="review">
					  		<div class="stars">
							    <span>
							      <input id="2review01" type="radio" name="evaluate2" value="5"><label for="2review01">　★</label>
							      <input id="2review02" type="radio" name="evaluate2" value="4"><label for="2review02">　★</label>
							      <input id="2review03" type="radio" name="evaluate2" value="3"><label for="2review03">　★</label>
							      <input id="2review04" type="radio" name="evaluate2" value="2"><label for="2review04">　★</label>
							      <input id="2review05" type="radio" name="evaluate2" value="1"><label for="2review05">★</label>
							    </span>
					 		 </div>
						</div>
					</td>
				</tr>
				<tr>
					<th>質問3：報告・連絡・相談が適切にできている</th>
					<td>
						<div class="review">
					  		<div class="stars">
							    <span>
							      <input id="3review01" type="radio" name="evaluate3" value="5"><label for="3review01">　★</label>
							      <input id="3review02" type="radio" name="evaluate3" value="4"><label for="3review02">　★</label>
							      <input id="3review03" type="radio" name="evaluate3" value="3"><label for="3review03">　★</label>
							      <input id="3review04" type="radio" name="evaluate3" value="2"><label for="3review04">　★</label>
							      <input id="3review05" type="radio" name="evaluate3" value="1"><label for="3review05">★</label>
							    </span>
					 		 </div>
						</div>
					</td>
				</tr>
				<tr>
					<th>質問4：業務に必要な技術や知識を発揮できている</th>
					<td>
						<div class="review">
					  		<div class="stars">
							    <span>
							      <input id="4review01" type="radio" name="evaluate4" value="5"><label for="4review01">　★</label>
							      <input id="4review02" type="radio" name="evaluate4" value="4"><label for="4review02">　★</label>
							      <input id="4review03" type="radio" name="evaluate4" value="3"><label for="4review03">　★</label>
							      <input id="4review04" type="radio" name="evaluate4" value="2"><label for="4review04">　★</label>
							      <input id="4review05" type="radio" name="evaluate4" value="1"><label for="4review05">★</label>
							    </span>
					 		 </div>
						</div>
					</td>
				</tr>
				<tr>
					<th>質問5：タスク量と期限は適切である</th>
					<td>
						<div class="review">
					  		<div class="stars">
							    <span>
							      <input id="5review01" type="radio" name="evaluate5" value="5"><label for="5review01">　★</label>
							      <input id="5review02" type="radio" name="evaluate5" value="4"><label for="5review02">　★</label>
							      <input id="5review03" type="radio" name="evaluate5" value="3"><label for="5review03">　★</label>
							      <input id="5review04" type="radio" name="evaluate5" value="2"><label for="5review04">　★</label>
							      <input id="5review05" type="radio" name="evaluate5" value="1"><label for="5review05">★</label>
							    </span>
					 		 </div>
						</div>
					</td>
				</tr>
			</table>
		</span>
	</div>
	<br>
	<!-- 登録ボタン -->
	<div>
		<input type="submit" name="bt_name" value="登録" class = regist_btn  onclick="return confirm('この評価でよろしいですか')">
	</div><br>

	<div class = "alert" id="errMsg">${errMsg}</div><br>

</form>
</main>
</body>
</html>