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
				
				 var btn = "<button class='btnTermini btn btn-danger' id = " + data[i]['id'] + ">Termini</button>";
	              row += "<td>" + btn + "</td>"; 
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
