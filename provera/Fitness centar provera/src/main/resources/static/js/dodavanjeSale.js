$(document).on("submit","salaForm",function(event){
	event.preventDefault();
	
	var oznaka=$("#oznaka").val();
	var kapacitet=$("#kapacitet").val();
	var fitnessCentar=$("#fitnessCentar").val();
	
	
	var newSalaJSON=formToJSON(oznaka,kapacitet,fitnessCentar);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/sala",
		dataType:"json",
		contentType:"application/json",
		data:newSalaJSON,
		success:function(){
			alert("Sala je uspešno dodata");
			
		},
		error:function(data){
			alert("Greška");
			location.reload(true);
		}
		
	});
	
});

function formToJSON(oznaka,kapacitet,fitnessCentar){
	return JSON.stringify({
		"oznakaSale":oznaka,
		"kapacitet":kapacitet,
		"fitnessCentar":fitnessCentar
		
	});
}

