$(document).ready(function () {
	var Scroll = function  () {
		$('html, body').stop(true, true).animate({scrollTop: $(this.hash).offset().top - navHight + 1}, 600);
		return false;
	};
	$winWidth = $(window).width()
	nav = $(".main-header");
	if($winWidth > 767){
		nav.stick_in_parent();		
		navHight = $(".main-header").height();
		$('.navbar-nav li a').on('click', function  () {
			$('html, body').stop(true, true).animate({scrollTop: $(this.hash).offset().top - navHight + 1}, 600);
			return false;
		});
	}
	var slider = $('.blog-slider');
	var testimonial = $('.testimonial-slider-wrap ul');
	testimonial.bxSlider({
		pager : false
	})
	slider.bxSlider({
		minSlides: 1,
		maxSlides: 3,
		moveSlides: 1,
		slideWidth: 367,
		slideMargin: 20,
		pager : false,
	})
})

$(window).bind('scroll resize', function() {
	$winWidth = $(window).width()
	if($winWidth > 767){
		var nav = $(".main-header");
	    var currentSection = null;
	    $('[data-target]').each(function(){
	        var element = $(this).attr('id');	
	        if ($('#'+element).is('*')){
	            if($(window).scrollTop() >= $('#'+element).offset().top - nav.height())
	            {
	                currentSection = element;
	            }
	        }
	    });
	    $('.navbar-nav li').removeClass('active').find('a[href="#'+currentSection+'"]').parent().addClass('active');
	}
});
$(window).load(function (argument) {
	var $container = $('.items_container');
	var $width = $('.items_container li');;
	$container.isotope({
	  layoutMode: 'fitRows',
	})
	$('.filter-list').on( 'click', 'a', function() {
	  if($(this).parent().hasClass('active')){
	  }
	  else{
	  	$(this).parent().parent().children().removeClass('active');
	  	$(this).parent().addClass('active');
	  }
	  var filterValue = $(this).attr('data-filter');
	  $container.isotope({ filter: filterValue });
	  return false;
	});
	$(".fancybox").fancybox();
})

