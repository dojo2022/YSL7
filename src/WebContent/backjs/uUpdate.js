
document.getElementById("uUpdateReturn").addEventListener('click',()=>{
	history.back();
});
function check(){
	if(window.confirm("本当に退職しますか？")){
		if(window.confirm("もうちょっと考えてみませんか？")){
			window.alert("わかりました。新天地でのご活躍をお祈りします");
		return} else{return};
	} else{return};
};
