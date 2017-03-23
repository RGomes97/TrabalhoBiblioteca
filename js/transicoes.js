function iniciar(){
    $('.busca').hide();
    $('.sub-busca').hide();
}

iniciar();

$('.li-header').click(function(){
	document.getElementsByClassName('li-header')[1].addEventListener("click", function(){
	$('.busca').fadeIn(1000);
    $('.sub-busca').fadeIn(1000);

    var li = document.getElementsByClassName('li-header');
	for(var i = 0; i < li.length; i++){
		li[i].classList.remove('active');
	}
	li[1].classList.add('active');	
	});
});

$('.li-header').click(function(){
	$('.busca').fadeOut(1000);
    $('.sub-busca').fadeOut(1000);

    var li = document.getElementsByClassName('li-header');
	for(var i = 0; i < li.length; i++){
		li[i].classList.remove('active');
	}

	li[0].classList.add('active');
})

