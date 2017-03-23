function iniciar(){
    $('.busca').hide();
    $('.sub-busca').hide();
}

iniciar();

function mostrarBusca(){
    $('.busca').fadeIn(1000);
    $('.sub-busca').fadeIn(1000);
}

function esconderBusca(){
    $('.busca').fadeOut(1000);
    $('.sub-busca').fadeOut(1000);
}