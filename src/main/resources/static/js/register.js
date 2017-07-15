function doRegister(){
        
	    var form = $('#registerForm');     
        var formData = {}
 	 
        $.each(form.serializeArray(),function(){
	      formData[this.name] = this.value;	      
        });
         
         console.log(JSON.stringify(formData));
        $.ajax({
            type: form.attr('method'), // method attribute of form
            url: form.attr('action'),  // action attribute of form
            dataType : 'json',
            contentType:"application/json; charset=utf-8",	   
            data : JSON.stringify(formData),
            success : function(data) {				
				if(data.result == 'ok'){
					$("#error").hide();
					window.location='/login';					
				}else{
					displayError("Registration not successful");
				}
			},
			error : function() {								
				displayError("error with server connection");
			}
         });
}

function displayError(message){
    $("#error").append(message).show();
}