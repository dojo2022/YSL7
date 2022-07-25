//入力内容に間違いはありませんか？

			function uRegist() {
/*			let number = (document.getElementByName("number")[0].value);
		 	let name = (document.getElementByName("name")[0].value);
		 	let gender = (document.getElementByName("gender")[0].value);
		 	let depId = (document.getElementByName("dep_id")[0].value);
		 	let divId = (document.getElementByName("div_id")[0].value);
		 	let secId = (document.getElementByName("sec_id")[0].value);
		 	let post1 = (document.getElementByName("post1")[0].value);
		 	let year = (document.getElementByName("year")[0].value);

			//もしも空白があったらエラーを出す
			if(number == ""){
				document.getElementById("number_error").textContent = "社員番号を入力してください";
			}
			if(name == ""){
				document.getElementById("name_error").textContent = "名前を入力してください";
			}
			if(gender == ""){
				document.getElementById("gender_error").textContent = "性別を入力してください";
			}
			if(depId == ""){
				document.getElementById("depId_error").textContent = "部署名を入力してください";
			}
			if(divId == ""){
				document.getElementById("divId_error").textContent = "部を入力してください";
			}
			if(secId == ""){
				document.getElementById("secId_error").textContent = "課を入力してください";
			}
			if(post1 == ""){
				document.getElementById("post1_error").textContent = "役職１を入力してください";
			}
			if(year == ""){
				document.getElementById("year_error").textContent = "役職１を入力してください";
			}

*/				let con = window.confirm('入力内容に間違いはありませんか？');
					if(con == true){
						 return true;
					} else {
						return false;
					}
			}


//一覧に戻り戻りますか？

			function back() {
				let con = window.confirm('一覧に戻りますか？');

					if(con == true){
						 return true;
					} else {
						return false;
					}
			}



//入力値のチェック

		//①計算ボタンが押された際に処理される（無名関数を使用する）----------------------------
        document.getElementByName("").onclick = function() {
			//テキストボックスの値を取得してくる
			let number = (document.getElementByName("number").value);
		 	let name = (document.getElementByName("name").value);
		 	let gender = (document.getElementByName("gender").value);
		 	let depId = (document.getElementByName("dep_id").value);
		 	let divId = (document.getElementByName("div_id").value);
		 	let secId = (document.getElementByName("sec_id").value);
		 	let post1 = (document.getElementByName("post1").value);
		 	let year = (document.getElementByName("year").value);

			//もしも空白があったらエラーを出す
			if(number == ""){
				document.getElementById("number_error").textContent = "社員番号を入力してください";
			}
			if(name == ""){
				document.getElementById("name_error").textContent = "名前を入力してください";
			}
			if(gender == ""){
				document.getElementById("gender_error").textContent = "性別を入力してください";
			}
			if(depId == ""){
				document.getElementById("depId_error").textContent = "部署名を入力してください";
			}
			if(divId == ""){
				document.getElementById("divId_error").textContent = "部を入力してください";
			}
			if(secId == ""){
				document.getElementById("secId_error").textContent = "課を入力してください";
			}
			if(post1 == ""){
				document.getElementById("post1_error").textContent = "役職１を入力してください";
			}
			if(year == ""){
				document.getElementById("year_error").textContent = "役職１を入力してください";
			}


			}

