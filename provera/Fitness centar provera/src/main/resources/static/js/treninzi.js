// Prikaz svih treninga
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih treninga sa backend-a i prikaz u tabeli
   
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/termin",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";       
                 row += "<td>" + termin.dan + "</td>";   
                row += "<td>" + termin.vreme + "</td>";    // ubacujemo podatke jednog treninga u polja
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.brojRezervacija + "</td>";        
                row += "<td>" + termin.naziv + "</td>";
                row += "<td>" + termin.opis + "</td>";
                row += "<td>" + termin.tipTreninga + "</td>";      
                row += "<td>" + termin.trajanje + "</td>";                // kreiramo red za tabelu
               
               
                // kreiramo button i definisemo custom data atribut id = id treninga
                let btn = "<button class='btnRezervisi' data-id=" + termin.id + ">Rezerviši</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#termini').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = treninzi
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});



// Sortiranje termina po ceni
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih treninga sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/termin/sortCena",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                                // kreiramo red za tabelu
                row += "<td>" + termin.dan + "</td>";   
                row += "<td>" + termin.vreme + "</td>";    // ubacujemo podatke jednog treninga u polja
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.brojRezervacija + "</td>";
                row += "<td>" + termin.naziv + "</td>";
                row += "<td>" + termin.opis + "</td>";
                row += "<td>" + termin.tipTreninga + "</td>";      
                row += "<td>" + termin.trajanje + "</td>";   
                
                // kreiramo button i definisemo custom data atribut id = id treninga
                let btn = "<button class='btnRezerviši' data-id=" + termin.id + ">Rezerviši</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#sorttermini').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = treninzi
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});

$(document).on('click', '.btnRezervisi', function () {            
	
	
	$("#treningic").empty();
	$("#kartica1").hide();
        $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trening/rezervisi/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
        	
        	
        		//var red="<p value="+data['id']+"></p>";
        		
        		var red="<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
	             red+="<input type='text' class='form-control' id='podatak' placeholder='Izabrnai id' value="+data['id']+"></div>"
	              $('#treningic').append(red);
	              $("#kartica1").removeClass("d-none").show();
	              
        	
        	 //window.location.href="index.html";
        	
                                  
           
        },
        error: function (data) {
        	alert("Neuspjesno, pokusajte opet");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '#rezervacija', function () {            // kada je button (čija je class = btnSeeMore) kliknut
	event.preventDefault();
	$("#kartica1").hide();
	
	var korisnickoIme=$("#korisnickoIme").val();
	var lozinka=$("#lozinka").val();
	var id=$("#podatak").val();
   
	var newKorisnikJSON=formToJSON1(korisnickoIme,lozinka,id);
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/trening/rezervacija",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(data){
			alert("Uspjesno");
			
			
			
		},
		error:function(data){
			
			alert("Greska! Korisnik sa unijetim podacima je neposotjeći");
			window.location.href="pretraga.html";
        }
    });
});

function formToJSON1(korisnickoIme,lozinka,id){
	return JSON.stringify({
		"korisnickoIme":korisnickoIme,
		"lozinka":lozinka,
		"id":id
		
	});
}