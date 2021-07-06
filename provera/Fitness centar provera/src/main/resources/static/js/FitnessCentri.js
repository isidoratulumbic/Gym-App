$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/fitnessCentar",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
			
				row+="<td>"+data[i]['naziv']+"</td>";
				row+="<td>"+data[i]['adresa']+"</td>";
				row+="<td>"+data[i]['broj_telefona_centrale']+"</td>";
				row+="<td>"+data[i]['email']+"</td>";
				
				  var btn = "<button class='obrisiFC' id = " + data[i]['id'] + ">Obriši</button>";
	              row += "<td>" + btn + "</td>"; 
	              var izmena = "<button class='izmeniFC' id = " + data[i]['id'] + ">Izmeni</button>";
	              row += "<td>" + izmena + "</td>"; 
	            
	             
	          
	              
	              
                
	              row+="</tr>";
	             row+="<br>";
	             $('#tabela').append(row);

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});
// Dodavanje novog FC
$(document).on("submit", "#fitnessCentarForm", function (event) {     // kada je submit-ovana forma za kreiranje novog FC
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let naziv = $("#naziv").val();
    let adresa = $("#adresa").val();
    let broj_telefona_centrale = $("#broj_telefona_centrale").val();
    let email = $("#email").val();

    // kreiramo objekat FC
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newFitnessCentar = {
        naziv,
        adresa,
        broj_telefona_centrale,    // zbog backend-a jobPosition moramo preimenovati u atribut position
        email
    }
    
    // ajax poziv za kreiranje novog FC na backend-u
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/fitnessCentar",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newFitnessCentar),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Fitness Centar " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            window.location.href = "fitnessCentri.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja fitness centra!");
        }
    });
});

//Brisanje FC
$(document).on('click', '.obrisiFC', function () {       
    

 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fitnessCentar/fitnessCentri/obrisi/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	alert("Fitness centar je uspešno obrisan!");
        	location.reload(true); //osvezavanje tabele odmah nakon brisanja
                           
           
        },
        error: function (data) {
        	alert("Došlo je do greške!");
            console.log("ERROR : ", data);
        }
    });
});


//Izmena FC

$(document).on('click', '.izmeniFC', function () {        
	
	$("#izmenaFitnessCentra").empty();
	
	$.ajax({  //FCController
		    type: "GET",
		    //uzimam podatke za gledaoca i od te terminske liste
		url: "http://localhost:8080/api/fitnessCentar/izmeniFC/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
		dataType: "json",
		success: function (data){
	
			
			var red="Naziv fitness centra:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='naziv' placeholder='Naziv fitness centra' value="+data['naziv']+" ></div>"
            
           
            red+="Adresa:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='adresa' placeholder='Adresa' value="+data['adresa']+"  ></div>"
            
            red+="Broj centrale:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='broj_telefona_centrale' placeholder='broj_telefona_centrale' value="+data['broj_telefona_centrale']+"  ></div>"
            
            red+="Email:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='email' class='form-control' id='email' placeholder='email' value="+data['email']+"  ></div>"
            
          console.log("EMAIL",data['email']);
            
			red+="<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='fitnessCentarId' placeholder='Izabrnai id' value="+data['id']+"  disabled='disabled'></div>"
             $('#izmenaFitnessCentra').append(red);
             $("#Izmena-FC").removeClass("d-none").show();
			 
			
		   
		},
		error: function (data) {
			alert("Neuspešno, pokušajte opet");
			 window.location.href="fitnessCentri.html";
		    console.log("ERROR : ", data);
		    }
		});
});


$(document).on('click', '#izmeni', function () {            // kada je button (čija je class = btnSeeMore) kliknut
	event.preventDefault();
	$("#Izmena-FC").hide();
	
	var naziv=$("#naziv").val();
	var adresa=$("#adresa").val();
	var broj_telefona_centrale=$("#broj_telefona_centrale").val();
	var email=$("#email").val()
	var id=$("#fitnessCentarId").val();
	

   
	var newFCJSON=formToJSON3(naziv,adresa, broj_telefona_centrale,email,id);
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/fitnessCentar/izmenjivanjeFC",
		dataType:"json",
		contentType:"application/json",
		data:newFCJSON,
		success:function(data){
			alert("Uspešno");
			window.location.href="fitnessCentri.html";
			
			
		},
		error:function(data){
			
			alert("Greska!");
			window.location.href="fitnessCentri.html";
        }
    });
});

function formToJSON3(naziv,adresa,broj_telefona_centrale,email,id){
	return JSON.stringify({
		"naziv":naziv,
		"adresa":adresa,
		"broj_telefona_centrale":broj_telefona_centrale,
		"email":email,
		"id":id
		
		
	});
}

