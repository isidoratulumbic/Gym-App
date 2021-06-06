$(document).on("submit","form",function(event){
	event.preventDefault();
	
	var naziv=$("#naziv").val();
	var adresa=$("#adresa").val();
	var broj_telefona_centrale=$("#broj").val();
	var email=$("#mail").val();
	var treneri=$("#trener").val();
	
	var newFitnessCentarJSON=formToJSON(naziv,adresa,broj_telefona_centrale,email,treneri);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/dodavanjeFC.html",
		dataType:"json",
		contentType:"application/json",
		data:newFitnessCentarJSON,
		success:function(){
			alert("Fitness Centar je uspesno dodat!");
			window.location.href="fitnessCentri.html";
		},
		error:function(data){
			alert("Greska");
			window.location.href="greskaDodavanjeFC.html";
		}
		
	});
	
});

function formToJSON(naziv,adresa,broj,email,treneri){
	return JSON.stringify({
		"naziv":naziv,
		"adresa":adresa,
		"broj_telefona_centrale":broj,
		"email":email,
		"treneri":treneri
	});
}