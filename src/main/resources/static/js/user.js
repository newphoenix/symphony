function doAjax(){
        
	    var form = $('#submitForm');     
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
					console.log(data);					
				} 
			},
			error : function() {
				console.log("error");
			}
         });
}