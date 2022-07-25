/**
 *
 */
$(function() {
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