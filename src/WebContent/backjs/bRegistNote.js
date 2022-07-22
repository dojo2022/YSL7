/**
 *
 */
function check(){
	window.alert("以下の内容でメモを登録しますか？");
}

document.getElementById("noteReturn").addEventListener('click',()=>{
	history.back();
});