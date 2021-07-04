$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/sala",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
			
				row+="<td>"+data[i]['oznaka']+"</td>";
				row+="<td>"+data[i]['kapacitet']+"</td>";
				
				
				 var btn = "<button class='obrisiSalu' id = " + data[i]['id'] + ">Obriši</button>";
	              row += "<td>" + btn + "</td>"; 
	              var izmena = "<button class='izmeniSalu' id = " + data[i]['id'] + ">Izmeni</button>";
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
// Dodavanje novog Sale
$(document).on("submit", "#salaForm", function (event) {     // kada je submit-ovana forma za kreiranje novog FC
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let naziv = $("#oznaka").val();
    let adresa = $("#kapacitet").val();
   

    // kreiramo objekat sale
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newFitnessCentar = {
        oznaka,
        kapacitet,
        
    }
    
    // ajax poziv za kreiranje nove sale na backend-u
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/api/sala",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newSala),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Sala " + response.id + " je uspešno kreirana!");// prikazujemo poruku uspeha korisniku
            window.location.href = "Sale.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja sale!");
        }
    });
});


