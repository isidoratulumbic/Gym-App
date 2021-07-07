$(document).on("submit","form",function(event){
	event.preventDefault();
	var loginKartica=$("#kartica").hide();

	
		
	var korisnickoIme=$("#korisnickoIme").val();
	var lozinka=$("#lozinka").val();
	
	var newKorisnikJSON=formToJSON(korisnickoIme,lozinka);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/trener/login",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(data){
			console.log("SUCCESS: ",data);
			
			$("#ime").append(data['ime']);
			$("#korisnicko").append(data['korisnickoIme']);
			$('#loz').append(data['lozinka']);
			$('#name').append(data['ime']);
			$('#prezime').append(data['prezime']);
			$('#telefon').append(data['kontakt_telefon']);
			$('#email').append(data['email']);
			$('#datum').append(data['datum_rodjenja']);
			$('#uloga').append(data['uloga']);
			
			
			
			  var profil=$("#profil1").removeClass("d-none").show();
			
		},
		error:function(data){
			var loginKartica=$("#kartica").show();
			alert("Greska! Član sa unetim podacima je nepostojeći");
		}
	});
	
});

function formToJSON(korisnickoIme,lozinka){
	return JSON.stringify({
		"korisnickoIme":korisnickoIme,
		"lozinka":lozinka
		
	});
}


 