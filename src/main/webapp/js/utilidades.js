$(document).ready(function() {
    $("#fechaNacimiento").datepicker({
        changeMonth: true,
        changeYear: true
    });

    jQuery.validator.setDefaults({
        debug: true,
        success: "valid"
    });
    
    $("#login").validate({
        rules: {
            email: {
//                required: true,
                email: true                
            }
        }
    });
    $("#alta").validate({        
        rules: {
            email: {
//                required: true,
                email: true                
            },
            email_again: {
                equalTo: "#emailAlta"                
            }
        }
    });    
});