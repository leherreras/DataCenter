$(document).on("ready",function(){

    document.ondragstart = function(){
        return false;
    };
    //document.getElementById('ResHomy').ondragstart = function() { return false; };
    // Evitar Arrastrar Imagen.   
    
    document.oncontextmenu = function(){
       return false;
    }; //Evitar Click Derecho.

});
