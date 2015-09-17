
$(document).on('ready', function () {

    //Remove Element Class.

    /*
     $('.buttonLoginClient').removeClass('ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only');
     
     $('.buttonLoginClient').mouseover(function(){
     $('.buttonLoginClient').removeClass('ui-state-hover');
     });
     
     $('.buttonLoginClient').focus(function(){
     $('.buttonLoginClient').removeClass('ui-state-focus');
     });
     
     $('.buttonLoginClient').click(function(){
     $('.buttonLoginClient').removeClass('ui-state-hover').removeClass('ui-state-active');
     });
     */

    //Show Modals.

    $('.AccessLoginClientResHomy').on('click', function () {
        setTimeout(function () {
            $('.ModalLoginClient').modal('show');
        }, 600);
    });

    $('.AccessLoginCollaboratorResHomy').on('click', function () {
        setTimeout(function () {
            $('.ModalLoginCollaborator').modal('show');
        }, 600);
    });

    $('.AccessRegisterClientResHomy').on('click', function () {
        setTimeout(function () {
            $('#ModalRegisterClient').modal('show');
        }, 600);
    });
    
    //Close Modal.
    
    $('.buttonCancelAccess').on('click', function(){
        $('#ModalLoginClient').modal('hide');
    });
    
    //Agrandar Telón de Fondo (Modal Bootstrap)    
    setInterval(function () { 

        if (!$("body").hasClass("modal-open")) return;

        var modalDialog = $(".modal.in > .modal-dialog");
        var backdrop = $(".modal.in > .modal-backdrop");
        var backdropHeight = backdrop.height();
        var modalDialogHeight = modalDialog.height();

        if (modalDialogHeight > backdropHeight) backdrop.height(modalDialogHeight + 300);

    }, 4000);

});
