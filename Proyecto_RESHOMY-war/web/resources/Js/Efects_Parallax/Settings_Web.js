$(document).on("ready",function(){

    function Configuration(Static){

        //document.getElementById('ResHomy').ondragstart = function() { return false; };
        // Evitar Arrastrar Imagen. 
        document.ondragstart = function(){
            return false;
        };         
        
        if(Static === true)
        {
            document.oncontextmenu = function(){
                $('#Advertencia').modal('show');
               return false;
            }; //Evitar Click Derecho.             
        }
        else
        {
            document.oncontextmenu = function(){
               return false;
            };             
        }
    };
    
    $(function(){
        $('#Bienvenido').modal('show');
        Configuration(false);
    });
    
    setTimeout(function(){
        $('#Bienvenido').modal('hide');
    },4000);
    
    setTimeout(function(){
        Configuration(true);
    },4180);

});
