<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規社員登録</title>
</head>
<body>
	<h1>新規社員登録</h1>

	<form method="POST" action="/miemo/servlet/BControllerServlet">
	<input type="hidden" name="page_id" value="BR01">
		<table>
			<tr>
				<td>社員番号</td>
				<td><input type="text" name="number"></td>
			</tr>
			<tr>
				<td>氏名</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>性別</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>事業部</td>
				<td>
					<select name="OS">
						<option value="">OSを選択</option>
						<c:forEach var="e" items="${one}" varStatus="status">
							<option value="${e}">${e}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>部</td>
				<td><select name="version">  	</select></td>
			</tr>
			<tr>
				<td>課</td>
				<td><select name="comment">  	</select></td>
			</tr>
			<tr>
				<td>役職1</td>
				<td>
					<select name="post1">
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
					  </select>
				<td><!-- プルダウン -->
			</tr>
			<tr>
				<td>役職1</td>
				<td>
					<select name="post1">
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
					  </select>
				<td><!-- プルダウン -->
			</tr>
			<tr>
				<td>役職1</td>
				<td>
					<select name="post1">
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
					  </select>
				<td><!-- プルダウン -->
			</tr>


		</table>

		<input type="submit" name="buttn_id" value="登録">
	</form>
</body>

<script>

	//リクエストスコープから値を取得して、変数に格納
	//文字列を使用しているので、関数を通して配列として格納
	let one = createArray("${one}");
	let two = createArray("${two}");
	let three = createArray("${three}");
 	let three2 = createArray("${three2}");

	let array = new Array(two,three,three2);

	//ここから変数宣言-----------------------------------------------------------------
	//配列の宣言
	let versionArray = new Array();
	//配列の初期値の設定
	versionArray[''] = new Array('バージョン情報');

	//配列の宣言
	let commentArray = new Array();
	//配列の初期値の設定
	commentArray[''] = new Array('コメント情報');


	for(let i=0;i<one.length;i++){
		versionArray[one[i].trim()] = array[i];
	}

	for(let i=0;i<two.length;i++){
		commentArray[two[i]] =array[i+2];

	}
	for(let i=0;i<two2.length;i++){
		commentArray[two2[i]] =array[i+4];

	}

	//ここから関数-----------------------------------------------------------------
	//ひとつめの配列の値が変更されたときに動く関数
	document.getElementsByName('OS')[0].onchange = function () {
		let os = this.value;
		let elm = document.getElementsByName('version')[0];
		elm.options.length = 0;
		for (let i = 0; i < versionArray[os].length; i++) {
			let op = document.createElement('option');
			op.value = versionArray[os][i];
			op.textContent = versionArray[os][i];
			elm.appendChild(op);
		}
	};
	//ふたつめの配列の値が変更されたときに動く関数
	document.getElementsByName('version')[0].onchange = function () {
		let version = this.value;
		let elm = document.getElementsByName('comment')[0];
		elm.options.length = 0;
		for (let i = 0; i < commentArray[version].length; i++) {
			let op = document.createElement('option');
			op.value = commentArray[version][i];
			op.textContent = commentArray[version][i];
			elm.appendChild(op);
		}
	};

	//JSPの画面が読み込まれたときに実行される関数
	window.onload = function () {
		document.getElementsByName('OS')[0].onchange();
	};

	//もらった値は文字列型なので、成形して配列にする関数
	function createArray(element){
		let ans = element.replace('[','');
		ans = ans.replace(']','');
		let arr = ans.split(',');
		return arr;
	}
</script>
</html>