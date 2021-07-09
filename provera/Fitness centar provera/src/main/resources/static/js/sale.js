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
				row+="<td>"+data[i]['fitnessCentar']+"</td>";
				
				
				
				 var btn = "<button class='obrisiSalu' id = " + data[i]['id'] + ">Obriši</button>";
	              row += "<td>" + btn + "</td>"; 
	              var izmena = "<button class='izmeniSalu' id = " + data[i]['id'] + ">Izmeni</button>";
	              row += "<td>" + izmena + "</td>"; 
	             
	              
	              row+="</tr>";
	             row+="<br>";
	             $('#tabela1').append(row);
				$("#sale").removeClass("d-none").show(); 
			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

// Dodavanje nove sale
$(document).on("submit", "#salaForm", function (event) {     // kada je submit-ovana forma za kreiranje novog FC
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme
	$("#Izmena-SALE").hide();
    // preuzimamo vrednosti unete u formi
    let oznaka = $("#oznaka").val();
    let kapacitet = $("#kapacitet").val();
    let fitnessCentar = $("#fitnessCentar").val();
    

    // kreiramo objekat FC
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newSala = {
        oznaka,
        kapacitet,
        fitnessCentar
           // zbog backend-a jobPosition moramo preimenovati u atribut position
        
    }
    
    // ajax poziv za kreiranje novog FC na backend-u
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

//Brisanje sale
$(document).on('click', '.obrisiSalu', function () {       
    

 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sala/obrisi/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	alert("Sala je uspešno obrisana!");
        	location.reload(true); //osvezavanje tabele odmah nakon brisanja
                           
           
        },
        error: function (data) {
        	alert("Došlo je do greške!");
            console.log("ERROR : ", data);
        }
    });
});


//Izmena Sale

$(document).on('click', '.izmeniSalu', function () {        
	
	$("#izmenaSale").empty();
	
	$.ajax({  //FCController
		    type: "GET",
		    //uzimam podatke za gledaoca i od te terminske liste
		url: "http://localhost:8080/api/sala/izmeniSALU/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
		dataType: "json",
		success: function (data){
		
	var red="Oznaka:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='oznaka' placeholder='Oznaka' value="+data['oznaka']+" ></div>"
            
           
            red+="Kapacitet:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='kapacitet' placeholder='Kapacitet' value="+data['kapacitet']+"  ></div>"
            
            
          
           
            
			red+="<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='salaId' placeholder='Izabrnai id' value="+data['id']+"  disabled='disabled'></div>"
             $('#izmenaSale').append(red);
             $("#Izmena-SALA").removeClass("d-none").show();
			 
			
		   
		},
		error: function (data) {
			alert("Neuspešno, pokušajte opet");
			 window.location.href="sale.html";
		    console.log("ERROR : ", data);
		    }
		});
});


$(document).on('click', '#izmeni', function () {            // kada je button (čija je class = btnSeeMore) kliknut
	event.preventDefault();
	$("#Izmena-SALA").hide();
	
	
	var oznaka=$("#oznaka").val();
	var kapacitet=$("#kapacitet").val();
	
	var id=$("#salaId").val();
	

   
	var newCLANJSON=formToJSON3(oznaka,kapacitet,id);
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/sala/izmenjivanjeSALE",
		dataType:"json",
		contentType:"application/json",
		data:newCLANJSON,
		success:function(data){
			alert("Uspešno");
			window.location.href="sale.html";
			
			
		},
		error:function(data){
			
			alert("Greska!");
			window.location.href="sale.html";
        }
    });
});

function formToJSON3(oznaka,kapacitet){
	return JSON.stringify({
		"oznaka":oznaka,
		"kapacitet":kapacitet
		
		
		
	});
}