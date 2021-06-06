$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:3050/api/bioskopi",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
			
				row+="<td>"+data[i]['naziv']+"</td>";
				row+="<td>"+data[i]['adresa']+"</td>";
				row+="<td>"+data[i]['broj_telefona_centrale']+"</td>";
				row+="<td>"+data[i]['email']+"</td>";
				
				 var btn = "<button class='btnUkloni btn btn-danger' id = " + data[i]['id'] + ">Ukloni</button>";
	              row += "<td>" + btn + "</td>"; 
	              var btn1 = "<button class='btnIzmeni btn btn-danger' id = " + data[i]['id'] + ">Izmeni</button>";
	              row += "<td>" + btn1 + "</td>"; 
	            
	              
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#tabela').append(row);
	             $("#fitnessCentri").removeClass("d-none").show();
	             

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

$(document).on('click', '.btnUkloni', function () {            // kada je button (čija je class = btnSeeMore) kliknut

    // nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
    // tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
    $.ajax({
        type: "GET",
        url: "http://localhost:3050/api/bioskopi/ukloni/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
           alert("Uspesno");
           window.location.href="fitnessCentri.html";
           
        },
        error: function (data) {
        	alert("Greska");
            console.log("ERROR : ", data);
           
        }
    });
});


$(document).on('click', '.btnIzmeni', function () {        
	//$("#repertoar").hide();
	$("#izmenaFitnessCentar").empty();
	
	$.ajax({  //FCController
		    type: "GET",
		    //uzimam podatke za clana i od te terminske liste
		url: "http://localhost:3050/api/bioskop-izmijeni/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
		dataType: "json",
		success: function (data){
	
			
			var red="Naziv fitness centra:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='naziv' placeholder='Naziv fitness centra' value="+data['naziv']+" ></div>"
            
           
            red+="Adresa:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='adresa' placeholder='Adresa' value="+data['adresa']+"  ></div>"
            
            red+="Broj centrale:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='brojCentrale' placeholder='broj' value="+data['brojCentrale']+"  ></div>"
            
            red+="Email:<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='email' class='form-control' id='email' placeholder='email' value="+data['email']+"  ></div>"
            
          console.log("MAIL",data['email']);
            
			red+="<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='bioskopId' placeholder='Izabrnai id' value="+data['id']+"  disabled='disabled'></div>"
             $('#izmenaFitnessCentar').append(red);
             $("#Izmena-fitnessCentar").removeClass("d-none").show();
			 
			
		   
		},
		error: function (data) {
			alert("Neuspesno, pokusajte opet");
			 window.location.href="prijava.html";
		    console.log("ERROR : ", data);
		    }
		});
});


$(document).on('click', '#izmeni', function () {            // kada je button (čija je class = btnSeeMore) kliknut
	event.preventDefault();
	$("#Izmena-fitnessCentar").hide();
	
	var naziv=$("#naziv").val();
	var adresa=$("#adresa").val();
	var broj=$("#brojCentrale").val();
	var mail=$("#email").val()
	var id=$("#fitnessCentarId").val();
	

   
	var newFitnessCentarJSON=formToJSON3(naziv,adresa,broj,mail,id);
	$.ajax({
		type:"POST",
		url:"http://localhost:3050/api/bioskop/izmjenjivanje",
		dataType:"json",
		contentType:"application/json",
		data:newFitnessCentarJSON,
		success:function(data){
			alert("Uspesno");
			window.location.href="uklanjanjeFC.html";
			
			
		},
		error:function(data){
			
			alert("Greska!");
			window.location.href="uklanjanjeFC.html";
        }
    });
});

function formToJSON3(naziv,adresa,broj,mail,id){
	return JSON.stringify({
		"naziv":naziv,
		"adresa":adresa,
		"brojCentrale":broj,
		"email":mail,
		"id":id
		
		
	});
}

