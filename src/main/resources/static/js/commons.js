var HTTP = "http://";

$(document).ready(function(){
	
	loadUserLinks();
});


function addLink(){
	
    var form = $('#linkForm');     
    var formData = {};
 
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
        	$("#error").empty().hide();	
			if(data.msg == 'ok'){
				
				
				var link = $("#link").val();
				var tag = $("#tag").val();
				
				$("#link").val('');
				$("#tag").val('');				
				
				appendToLinkTable(link,tag);
				
			}else if(data.msg == "nok"){
				displayError(data.result);
			}else if(data.msg == "exists"){
				displayError("Link already exists");
			}else{
				displayError("Didn't add link");
			}
		},
		error : function() {
			console.log("error");			
			displayError("error with server connection");
		}
     });
}


function loadUserLinks(){
	
    $.ajax({
        type: "get", // method attribute of form
        url: "link/getAll",  // action attribute of form
        dataType : 'json',
        contentType:"application/json; charset=utf-8",	   
        //data : JSON.stringify(formData),
        success : function(data) {				
			if(data.msg == 'ok'){
				
				 for(var i=0; i< data.links.length; i++){
					 
					 var link = data.links[i][0];
					 var tag = data.links[i][1];
					 
					 appendToLinkTable(link,tag);
				 }			
				
			}else{
				displayError("Registration not successful");
			}
		},
		error : function() {
			console.log("error");
			displayError("error with server connection");
		}
     });
	
	
}


function getSuggestions(){

	var link = $('#link').val();
	
	if(link.length < 1){ return;}
	
	$('#suggestion').empty();
    $.ajax({
        type: "get", // method attribute of form
        url: "link/getSuggestions?link="+link,  // action attribute of form
        dataType : 'json',
        contentType:"application/json; charset=utf-8",	   
        //data : JSON.stringify('link:'+link),
        success : function(data) {				
			if(data.msg == 'ok'){
		
				   for(var i=0;i< data.tags.length; i++){					   
					   $('#suggestion').append('<button style="border-radius: 20px; margin-left:3px" class="btn btn-primary disabled">'+data.tags[i]+'</button>')
				   }
				
			}
		},
		error : function() {
			console.log("error");
			displayError("error with server connection");
		}
     });
	
}

function appendToLinkTable(link,tag){
	 linkWithHttp = link.startsWith(HTTP)? link : HTTP+link;
	
	 $('#linkTable tr:last').after('<tr><td><a target="_blank" href="'+linkWithHttp+'">'+link+'</a></td><td>'+tag+'</td></tr>');
	
}

function displayError(message){
    $("#error").append(message).show();
}