$(document).on("ready",function(){

    //Efecto Entrar A Menú Principal..

    $("#Entrar1").hide();
    $("#Titulos").hide();
    
    $("#Entrar").hover(function(){   
            $(this).animate({opacity: 0});
            $("#Entrar1").show();
            $("#Entrar1").animate({opacity: 1}); 
            $("#Titulos").show();
    },function(){          
            $(this).animate({opacity: 1});
            $("#Entrar1").animate({opacity: 0});
            $("#Titulos").hide();
    });
     
   
});

