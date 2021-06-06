$(document).on("submit","form",function(event){		 // kada je submit-ovana forma za kreiranje novog zaposlenog
	event.preventDefault();							// sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme
													
													
	 // preuzimamo vrednosti unete u formi												
	var korisnickoIme=$("#korisnickoIme").val();
	var lozinka=$("#lozinka").val();
	var ime=$("#ime").val();
	var prezime=$("#prezime").val();
	var kontakt_telefon=$("#kontakt_telefon").val();
	var email=document.getElementById("email").value;
	var datum_rodjenja=$("#datum_rodjenja").val();
	
	// kreiramo objekat zaposlenog
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
	var newTrenerDTORegJSON=formToJSON(korisnickoIme,lozinka,ime,prezime,kontakt_telefon,email,datum_rodjenja);
	
	
	// ajax poziv za kreiranje novog clana na backend-u
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/trener",
		dataType:"json",
		contentType:"application/json",
		data:newTrenerDTORegJSON,
		success:function(){
			alert(ime+" "+prezime+" je uspešno registrovan kao trener!");
			window.location.href="prijava.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});
	
});

//pomocna funkcija koja od polja praavi JSON
function formToJSON(korisnicko,lozinka,ime,prezime,telefon,email,datum){
	return JSON.stringify({
		"korisnickoIme":korisnicko,
		"lozinka":lozinka,
		"ime":ime,
		"prezime":prezime,
		"kontakt_telefon":telefon,
		"email":email,
		"datum_rodjenja":datum
	});
}
	
