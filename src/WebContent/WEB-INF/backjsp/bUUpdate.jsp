<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報変更</title>
<link rel="stylesheet" href="/miemo/backcss/uUpdate.css">
<script type="text/javascript" src="/miemo/backjs/uUpdate.js"></script>
</head>
<body>

 <% session.setAttribute("profile",session.getAttribute("profile")); %>

	<h1>社員情報編集</h1>

	<!-- <form method="POST" action="/miemo/servlet/BControllerServlet"> -->
	<form method="POST" action="/miemo/TestServlet">
	<input type="hidden" name="page_id" value="BR02">
	<input type="hidden" name="empId" value="${empId}">
	<input type="submit" name="bt_name" value="退職" class="retire">
		<table>
			<tr>
				<td>社員番号</td>
				<td><input type="text" name="number" value="${profile.number}" class="inText"><br> <span id="error_number"></span></td>

			</tr>
			<tr>
				<td>氏名</td>
				<td><input type="text" name="name" value="${profile.name}" class="inText"><br> <span id="error_name"></span></td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
					<select name="gender"  class="inText">
						<option value="" id="uUpdateGender">性別を選択${profile.gender}</option>
					    <option value="0" <c:if test='${profile.gender==0}'> selected </c:if> >男性</option>
					    <option value="1" <c:if test='${profile.gender==1}'> selected </c:if> >女性</option>
					</select><br>
					<span id="error_gender"></span>
				</td>
			</tr>
			<tr>
				<td>事業部</td>
				<td>
					<select name="dep_id" class="inText">
						<option value="">事業部を選択</option>
						<c:forEach var="e" items="${one}" varStatus="status">
							<option value="${e}">${e}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>部</td>
				<td><select name="div_id">  	</select><br><span id="error_div_id"></span></td>
			</tr>
			<tr>
				<td>課</td>
				<td><select name="sec_id">  	</select><br><span id="error_sec_id"></span></td>
			</tr>
			<tr>
				<td>役職1</td>
				<td>
					<select name="post1" class="inText">
						<option value="">役職1を選択</option>
					    <option value="1"><c:if test="${profile.postId==1}selected"></c:if>契約社員</option>
					    <option value="2"><c:if test="${profile.postId==2}selected"></c:if>新人</option>
					    <option value="3"><c:if test="${profile.postId==3}selected"></c:if>一般職</option>
					    <option value="4"><c:if test="${profile.postId==4}selected"></c:if>総合職</option>
					    <option value="5"><c:if test="${profile.postId==5}selected"></c:if>主任職</option>
					    <option value="6"><c:if test="${profile.postId==6}selected"></c:if>専任職</option>
					    <option value="7"><c:if test="${profile.postId==7}selected"></c:if>管理職</option>
					    <option value="8"><c:if test="${profile.postId==8}selected"></c:if>顧問・嘱託</option>
					    <option value="9"><c:if test="${profile.postId=9}selected"></c:if>執行役員</option>
					    <option value="10"><c:if test="${profile.postId==10}selected"></c:if>取締役</option>
					  </select><br>
					  <span id="error_post1"></span>
				<td><!-- プルダウン -->
			</tr>
			<tr>
				<td>役職2</td>
				<td>
					<select name="post2" class="inText">
						<option value="">役職2を選択</option>
					    <option value="1">契約社員</option>
					    <option value="2">新人</option>
					    <option value="3">一般職</option>
					    <option value="4">総合職</option>
					    <option value="6">主任職</option>
					    <option value="7">専任職</option>
					    <option value="8">管理職</option>
					    <option value="9">顧問・嘱託</option>
					    <option value="10">執行役員</option>
					    <option value="11">取締役</option>
					 </select><br>
					  <span id="error_post2"></span>
				<td><!-- プルダウン -->
			</tr>
			<tr>
				<td>役職3</td>
				<td>
					<select name="post3" class="inText">
						<option value="">役職3を選択</option>
					    <option value="1">契約社員</option>
					    <option value="2">新人</option>
					    <option value="3">一般職</option>
					    <option value="4">総合職</option>
					    <option value="6">主任職</option>
					    <option value="7">専任職</option>
					    <option value="8">管理職</option>
					    <option value="9">顧問・嘱託</option>
					    <option value="10">執行役員</option>
					    <option value="11">取締役</option>
					  </select><br>
					  <span id="error_post3"></span>
				<td>
			</tr>
			<tr>
				<td>入社年度</td>
				<td>
					<select name="year" class="inText">
						<option value="${profile.year}">${profile.year}</option>
					    <option value="1991"><c:if test="${profile.postId==1991}selected"></c:if>1991</option>
					    <option value="1992"><c:if test="${profile.postId==1992}selected"></c:if>1992</option>
					    <option value="1993"><c:if test="${profile.postId==1993}selected"></c:if>1993</option>
					    <option value="1994"><c:if test="${profile.postId==1994}selected"></c:if>1994</option>
					    <option value="1995"><c:if test="${profile.postId==1995}selected"></c:if>1995</option>
					    <option value="1996"><c:if test="${profile.postId==1996}selected"></c:if>1996</option>
					    <option value="1997"><c:if test="${profile.postId==1997}selected"></c:if>1997</option>
					    <option value="1998"><c:if test="${profile.postId==1998}selected"></c:if>1998</option>
					    <option value="1999"><c:if test="${profile.postId==1999}selected"></c:if>1999</option>
					    <option value="2000"><c:if test="${profile.postId==2000}selected"></c:if>2000</option>
					    <option value="2001"><c:if test="${profile.postId==2001}selected"></c:if>2001</option>
					    <option value="2002"><c:if test="${profile.postId==2002}selected"></c:if>2002</option>
					    <option value="2003"><c:if test="${profile.postId==2003}selected"></c:if>2003</option>
					    <option value="2004"><c:if test="${profile.postId==2004}selected"></c:if>2004</option>
					    <option value="2005"><c:if test="${profile.postId==2005}selected"></c:if>2005</option>
					    <option value="2006"><c:if test="${profile.postId==2006}selected"></c:if>2006</option>
					    <option value="2007"><c:if test="${profile.postId==2007}selected"></c:if>2007</option>
					    <option value="2008"><c:if test="${profile.postId==2008}selected"></c:if>2008</option>
					    <option value="2009"><c:if test="${profile.postId==2009}selected"></c:if>2009</option>
					    <option value="2010"><c:if test="${profile.postId==2010}selected"></c:if>2010</option>
					    <option value="2011"><c:if test="${profile.postId==2011}selected"></c:if>2011</option>
					    <option value="2012"><c:if test="${profile.postId==2012}selected"></c:if>2012</option>
					    <option value="2013"><c:if test="${profile.postId==2013}selected"></c:if>2013</option>
					    <option value="2014"><c:if test="${profile.postId==2014}selected"></c:if>2014</option>
					    <option value="2015"><c:if test="${profile.postId==2015}selected"></c:if>2015</option>
					    <option value="2016"><c:if test="${profile.postId==2016}selected"></c:if>2016</option>
					    <option value="2017"><c:if test="${profile.postId==2017}selected"></c:if>2017</option>
					    <option value="2018"><c:if test="${profile.postId==2018}selected"></c:if>2018</option>
					    <option value="2019"><c:if test="${profile.postId==2019}selected"></c:if>2019</option>
					    <option value="2020"><c:if test="${profile.postId==2020}selected"></c:if>2020</option>
					    <option value="2021"><c:if test="${profile.postId==2021}selected"></c:if>2021</option>
					    <option value="2022"><c:if test="${profile.postId==2022}selected"></c:if>2022</option>
					</select><br>
					<span id="error_year"></span>
				<td><!-- プルダウン -->
			</tr>
			<tr>
				<td><input type="submit" name="bt_name" value="保存" class="submit"></td>
			</tr>
		</table>


	</form>
	<p>${errMsg}</p>
<!-- 		<a href="/miemo/servlet/BControllerServlet/?page_id=BR02&bt_name=戻る">戻る</a> -->
	<input type="button" value="戻る" id="uUpdateReturn" onclick="history.back()">
</body>
</html>