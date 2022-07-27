
/*  データテーブル用のjQuery-----------------------------------------*/
jQuery(function($){
	 // デフォルトの設定を変更（日本語化）--------------------
    $.extend( $.fn.dataTable.defaults, {
        language: {
            url: "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
        }
    });
	 //------------------------------------------------
	//データテーブルを使用
    $("#foo-table").DataTable();
});

/*もっと見る用のjQuery---------------------------------------------*/
$(function(){
	  $('.more-btn').on('click', function() {
	    if( $(this).children().is('.open') ) {
	      $(this).html('<img src="/miemo/img/minusBtn.png" class="close">').addClass('close-btn');
	      $(this).parent().removeClass('slide-up').addClass('slide-down');
	    } else {
	      $(this).html('<img src="/miemo/img/plusBtnRed.png" class="open">').removeClass('close-btn');
	      $(this).parent().removeClass('slide-down').addClass('slide-up');
	    }
	  });
	});

function check(){
	if(window.confirm("メモを削除してもよろしいでしょうか")){
		return true;
	}else{
		return false;
	}
}