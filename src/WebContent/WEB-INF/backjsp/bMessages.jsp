<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="/miemo/backcss/bStyle.css">
	<link rel="stylesheet" href="/miemo/backcss/bMessages.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="/miemo/backjs/bMessages.js"></script>
	<script type="text/javascript" src="/miemo/backjs/backCommon.js"></script>
</head>
<body>
<c:if test="${messageList.size()!=0}">
<table class="messageTable" >
	<thead>
			<tr>
				<th class="date">日付</th>
				<th>内容</th>
			</tr>
	</thead>
	<tbody>
		<c:forEach var="e" items="${messageList}" varStatus="status">
				<tr>
					<td>${e.date}</td>
					<td class="tw">
						<div class="content-wrap animated">
						  <div class="content-txt">
						    <p>${e.content}</p></div>
						  <div class="more-btn">
						    <img src="/miemo/img/plusBtnRed.png" class="open">
						  </div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
</table>
</c:if>
<c:if test="${messageList.size()==0}">
	<h3>メッセージはまだ届いていないようです。</h3>
</c:if>
</body>
</html>