<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規社員登録</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="/miemo/backcss/uRegist.css">
<script type="text/javascript" src="/miemo/backjs/uRegist.js"></script>
</head>
<body>
	<div class="title">
	<h1>新規社員登録</h1>
	</div>

	<!-- <form method="POST" action="/miemo/servlet/BControllerServlet"> -->
	<form method="POST" action="/miemo/BControllerServlet" id="uRegist">
	<input type="hidden" name="page_id" value="BR01">
	<!--  <input type="hidden" name="empId" value="1"> -->
		<table>
			<tr>
				<td>社員番号</td>
				<td><input type="text" name="number" value="${param.number}" id="number" class="inText"><br> <span id="error_number">${numberErrMsg}</span></td>

			</tr>
			<tr>
				<td>氏名</td>
				<td><input type="text" name="name" value="${param.name}" id="name" class="inText"><br> <span id="error_name" >${nameErrMsg}</span></td>
			</tr>
			<tr>
				<td>性別</td>
				<td>
					<select name="gender" class="inText" id="gender" >
						<option value="">性別を選択</option>
					    <option value="0">男性</option>
					    <option value="1">女性</option>
					</select><br>
					<span id="error_gender">${genderErrMsg}</span>
				</td>
			</tr>
			<tr>
				<td>事業部</td>
				<td>
					<select class="parent" name="foo">
					  <option value="" selected="selected">事業部を選択</option>
					  <c:forEach var="e" items="${role1}" varStatus="status">
						  <option value="${e.depId}">${e.department}</option>
					  </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>部</td>
				<td>
					<select class="children" name="bar" disabled>
					  <option value="" selected="selected">部を選択</option>
					   <c:forEach var="e" items="${role2}" varStatus="status">
							<option value="${e.divId }" data-val="${e.depId}">${e.division }</option>
					   </c:forEach>
					</select>
				  	<br><span id="error_div_id">${divIdErrMsg}</span>
				</td>
			</tr>
			<tr>
				<td>課</td>
				<td>

				<select class="grandchild" name="moo" disabled>
				  <option value="" selected="selected">課を選択</option>
				  <c:forEach var="e" items="${role3}" varStatus="status">
				  	<option value="${e.secId }" data-val="${e.divId }">${e.section }</option>
				  </c:forEach>

				</select>

				<br><span id="error_sec_id">${secIdErrMsg}</span></td>
			</tr>
			<tr>
				<td>役職1</td>
				<td>
					<select name="post1" class="inText" id="post1">
						<option value="">役職1を選択</option>
					    <option value="1">契約社員</option>
					    <option value="2">新人</option>
					    <option value="3">一般職</option>
					    <option value="4">総合職</option>
					    <option value="5">主任職</option>
					    <option value="6">専任職</option>
					    <option value="7">管理職</option>
					    <option value="8">顧問・嘱託</option>
					    <option value="9">執行役員</option>
					    <option value="10">取締役</option>
					  </select><br>
					  <span id="error_post1">${post1ErrMsg}</span>
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
					    <option value="5">主任職</option>
					    <option value="6">専任職</option>
					    <option value="7">管理職</option>
					    <option value="8">顧問・嘱託</option>
					    <option value="9">執行役員</option>
					    <option value="10">取締役</option>
					  </select><br>
					  <span id="error_post2"></span>
				<td><!-- プルダウン -->
			</tr>
			<tr>
				<td>役職3</td>
				<td>
					<select name="post3" class="inText">
						<option value="">役職2を選択</option>
					    <option value="1">契約社員</option>
					    <option value="2">新人</option>
					    <option value="3">一般職</option>
					    <option value="4">総合職</option>
					    <option value="5">主任職</option>
					    <option value="6">専任職</option>
					    <option value="7">管理職</option>
					    <option value="8">顧問・嘱託</option>
					    <option value="9">執行役員</option>
					    <option value="10">取締役</option>
					  </select><br>
					  <span id="error_post3"></span>
				<td>
			</tr>
			<tr>
				<td>入社年度</td>
				<td>
					<select name="year" class="inText" id="year">
						<option value="">入社年度を選択</option>
					    <option value="1991">1991</option>
					    <option value="1992">1992</option>
					    <option value="1993">1993</option>
					    <option value="1994">1994</option>
					    <option value="1995">1995</option>
					    <option value="1996">1996</option>
					    <option value="1997">1997</option>
					    <option value="1998">1998</option>
					    <option value="1999">1999</option>
					    <option value="2000">2000</option>
					    <option value="2001">2001</option>
					    <option value="2002">2002</option>
					    <option value="2003">2003</option>
					    <option value="2004">2004</option>
					    <option value="2005">2005</option>
					    <option value="2006">2006</option>
					    <option value="2007">2007</option>
					    <option value="2008">2008</option>
					    <option value="2009">2009</option>
					    <option value="2010">2010</option>
					    <option value="2011">2011</option>
					    <option value="2012">2012</option>
					    <option value="2013">2013</option>
					    <option value="2014">2014</option>
					    <option value="2015">2015</option>
					    <option value="2016">2016</option>
					    <option value="2017">2017</option>
					    <option value="2018">2018</option>
					    <option value="2019">2019</option>
					    <option value="2020">2020</option>
					    <option value="2021">2021</option>
					    <option value="2022">2022</option>
					</select><br>
					<span id="error_year">${yearErrMsg}</span>
				<td><!-- プルダウン -->
			</tr>
			<tr>
				<td> </td>
				<td> </td>
			</tr>
			<tr>
				<td>
				</td>
				<td><input type="submit" name="bt_name" value="登録" class="button" onclick ="return uRegist()"></td>
			</tr>
		</table>


	</form>
	<p>${errMsg}</p>
	<a href="/miemo/BControllerServlet?page_id=BL01&bt_name=戻る"  class="back" onclick ="return back()">一覧に戻る</a>
</body>


<script>
	var $children = $('.children'); //事業部の要素を変数に入れます。
	var original = $children.html(); //後のイベントで、不要なoption要素を削除するため、オリジナルをとっておく
	var $grandchild = $('.grandchild'); //部の要素を変数に入れます。
	var original2 = $grandchild.html(); //後のイベントで、不要なoption要素を削除するため、オリジナルをとっておく

	//--------------------------------------------------------------
	//事業部側のselect要素が変更になるとイベントが発生
	$('.parent').change(function() {

	//選択された事業部のvalueを取得し変数に入れる
	var val1 = $(this).val();


	//削除された要素をもとに戻すため.html(original)を入れておく
	$children.html(original).find('option').each(function() {
	var val2 = $(this).data('val'); //data-valの値を取得

	//valueと異なるdata-valを持つ要素を削除
	if (val1 != val2) {
	  $(this).not(':first-child').remove();
	}

	});

	//事業部側のselect要素が未選択の場合、事業部をdisabledにする
	if ($(this).val() == "") {
	$children.attr('disabled', 'disabled');
	} else {
	$children.removeAttr('disabled');
	}

	});

	//--------------------------------------------------------------
	$('.children').change(function() {

	  //選択された課のvalueを取得し変数に入れる
	  var val1 = $(this).val();


	  //削除された要素をもとに戻すため.html(original)を入れておく
	  $grandchild.html(original2).find('option').each(function() {
	    var val2 = $(this).data('val'); //data-valの値を取得

	    //valueと異なるdata-valを持つ要素を削除
	    if (val1 != val2) {
	      $(this).not(':first-child').remove();
	    }

	  });

	  //課側のselect要素が未選択の場合、課をdisabledにする
	  if ($(this).val() == "") {
	    $grandchild.attr('disabled', 'disabled');
	  } else {
	    $grandchild.removeAttr('disabled');
	  }

	});


/* 	//リクエストスコープから値を取得して、変数に格納
	//文字列を使用しているので、関数を通して配列として格納
	let one = createArray("${one}");
	let two = createArray("${two}");
	let three = createArray("${three}");
 	let three2 = createArray("${three2}");

	let array = new Array(two,three,three2);

	//ここから変数宣言-----------------------------------------------------------------
	//配列の宣言
	let divisionArray = new Array();
	//配列の初期値の設定
	divisionArray[''] = new Array('部を選択');

	//配列の宣言
	let sectionArray = new Array();
	//配列の初期値の設定
	sectionArray[''] = new Array('課を選択');

	divisionArray[one[0].trim()] = two;
	sectionArray[two[0]] =three;
	sectionArray[two[1]] =three2;


	/* for(let i=0;i<one.length;i++){
		divisionArray[one[i].trim()] = array[i];
	}

	for(let i=0;i<two.length;i++){
		sectionArray[two[i]] =array[i+2];

	}
	for(let i=0;i<two2.length;i++){
		sectionArray[two2[i]] =array[i+4];

	} */

	/*　//ここから関数-----------------------------------------------------------------
	//ひとつめの配列の値が変更されたときに動く関数
	document.getElementsByName('dep_id')[0].onchange = function () {
		let os = this.value;
		let elm = document.getElementsByName('div_id')[0];
		elm.options.length = 0;
		for (let i = 0; i < divisionArray[os].length; i++) {
			let op = document.createElement('option');
			op.value = divisionArray[os][i];
			op.textContent = divisionArray[os][i];
			elm.appendChild(op);
		}
	};
	//ふたつめの配列の値が変更されたときに動く関数
	document.getElementsByName('div_id')[0].onchange = function () {
		let version = this.value;
		let elm = document.getElementsByName('sec_id')[0];
		elm.options.length = 0;
		for (let i = 0; i < sectionArray[version].length; i++) {
			let op = document.createElement('option');
			op.value = sectionArray[version][i];
			op.textContent = sectionArray[version][i];
			elm.appendChild(op);
		}
	};

	//JSPの画面が読み込まれたときに実行される関数
	window.onload = function () {
		document.getElementsByName('dep_id')[0].onchange();
	};

	//もらった値は文字列型なので、成形して配列にする関数
	function createArray(element){
		let ans = element.replace('[','');
		ans = ans.replace(']','');
		let arr = ans.split(',');
		return arr;
	}

	function coloeSet(argObj){
	 // ==============================================
	 //	入力済み時の背景色設定
	 // ==============================================
	    if(argObj.value==""){
	        argObj.style.backgroundColor = "";
	    }else{
	        argObj.style.backgroundColor = "rgba(102, 51, 0, 0.20)";
	    }
	}

	function colorReset(argObj){
	    argObj.style.backgroundColor = "";
	} */

</script>
</html>