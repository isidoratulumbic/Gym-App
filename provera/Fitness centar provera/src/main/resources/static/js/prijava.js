$(document).on("submit","form",function(event){
	event.preventDefault();
	var loginKartica=$("#kartica").hide();

	
		
	var korisnickoIme=$("#korisnickoIme").val();
	var lozinka=$("#lozinka").val();
	
	var newKorisnikJSON=formToJSON(korisnickoIme,lozinka);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/clan/login",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(data){
			console.log("SUCCESS: ",data);
			sessionStorage.setItem("id", data["id"]);
			
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
			    rez="<button class='btnRezervisani btn-outline-danger btn-lg btn-block' id="+data['id']+">Rezervisani treninzi</button>";
				   rez+="<button  class='btnSvi btn-outline-danger btn-lg btn-block' id="+data['id']+">Odradjeni treninzi</button>";
				   rez+="<button class='btnNeocenjeni btn-outline-danger btn-lg btn-block' id="+data['id']+">Neocenjeni treninzi</button>";
				   rez+="<button class='btnOcenjeni btn-outline-danger btn-lg btn-block' id="+data['id']+">Ocenjeni treninzi</button>";
				  
				 $("#clan").append(rez);
				  $("#clan").removeClass("d-none").show();
			
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



$(document).on('click', '.btnRezervisani', function () {            // kada je button (čija je class = btnSeeMore) kliknut
    $("#odradjeniTreninzi").hide();
    $("#ocenjeniTreninzi").hide();
    $("#ocenjivanje").hide();
    $("#neocenjeniTreninzi").hide();
    $(".sakrij").empty();

    // nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
    // tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/clan/clan-rezervisaniTreninzi/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
        
        	for(i=0;i<data.length;i++){
        		var row="<tr class='sakrij'>";
        		row+="<td>"+data[i]['naziv']+"</td>";
        		row+="<td>"+data[i]['dan']+"</td>";
        		row+="<td>"+data[i]['vreme']+"</td>";
        		row+="<td>"+data[i]['cena']+"</td>";
        		row+="<td>"+data[i]['brojRezervacija']+"</td>";
        		row+="<td>"+data[i]['fitnessCentar']+"</td>";
        		row+="<td>"+data[i]['salaOznaka']+"</td>";
        		
        		
        		 var btn = "<button class='btnOtkazi btn btn-danger' value="+data[i]['clanId']+" id= " + data[i]['id']+ ">Otkaži</button>";
	              row += "<td>" + btn + "</td>"; 

	            
	              row+="</tr>";
	              
	              $('#tabela').append(row);
	              $("#listarezervacije").removeClass("d-none").show();
	              
        	}                          
           
        },
        error: function (data) {
        	alert("Neuspešno, pokušajte opet!");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.btnOtkazi', function () {        

	
	$.ajax({
		    type: "GET",
		    //uzimam podatke za clana i od te terminske liste
		url: "http://localhost:8080/api/clan/clan-otkaziRezervaciju/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
		dataType: "json",
		success: function (data){
			alert("Uspešno uklonjena rezervacija!");
		     $('#tabela').append(row);
	              
	              $("#listarezervacije").removeClass("d-none").show();
			 
			
		   
		},
		error: function (data) {
			alert("Neuspešno, pokušajte opet!");
		    console.log("ERROR : ", data);
		    }
		});
});

$(document).on('click', '.btnSvi', function () {            // kada je button (čija je class = btnSeeMore) kliknut
	  $("#listarezervacije").hide();
	  $("#ocenjeniTreninzi").hide();
	  $("#neocenjeniTreninzi").hide();
	  $("#ocenjivanje").hide();
	  $(".sakrij").empty();

    // nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
    // tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/clan/clan-odradjeniTreninzi/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function (data) {
        	
        	for(i=0;i<data.length;i++){
        		var row="<tr class='sakrij'>";
        		row+="<td>"+data[i]['naziv']+"</td>";
        		row+="<td>"+data[i]['tipTreninga']+"</td>";
        		row+="<td>"+data[i]['opis']+"</td>";
        		row+="<td>"+data[i]['trajanje']+"</td>";
        		row+="<td>"+data[i]['srednjaOcena']+"</td>";
        		
        		
        		
	              row+="</tr>";
	              
	              $('#tabela1').append(row);
	              
	              $("#odradjeniTreninzi").removeClass("d-none").show();
	              
	              
        	}                          
           
        },
        error: function (data) {
        	alert("Neuspešno, pokušajte opet!");
            console.log("ERROR : ", data);
        }
    });
});


$(document).on('click', '.btnOcenjeni', function () {            // kada je button (čija je class = btnSeeMore) kliknut
	 
	  $("#listarezervacije").hide();
	  $("#odradjeniTreninzi").hide();
	  $("#neocenjeniTreninzi").hide();
	  $(".sakrij").empty();
	 

  // nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
  // tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
  $.ajax({
      type: "GET",
      url: "http://localhost:8080/api/clan/clan-ocenjeniTreninzi/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
      dataType: "json",
      success: function (data) {
     
      	for(i=0;i<data.length;i++){
      		var row="<tr class='sakrij'>";
      		row+="<td>"+data[i]['naziv']+"</td>";
      		row+="<td>"+data[i]['tipTreninga']+"</td>";
      		row+="<td>"+data[i]['opis']+"</td>";
      		row+="<td>"+data[i]['trajanje']+"</td>";
      		row+="<td>"+data[i]['srednjaOcena']+"</td>";
      		
      		
      		
	              row+="</tr>";
	              
	              $('#tabela2').append(row);
	              
	              $("#ocenjeniTreninzi").removeClass("d-none").show();
	              
      	}                          
         
      },
      error: function (data) {
      	alert("Neuspešno, pokušajte opet!");
          console.log("ERROR : ", data);
      }
  });
});


$(document).on('click', '.btnNeocenjeni', function () {            // kada je button (čija je class = btnSeeMore) kliknut
    
	  $("#listarezrvacije").hide();
	  $("#odradjeniTreninzi").hide();
	  $("#ocenjeniTreninzi").hide();
	  $(".sakrij").empty();

// nakon što korisnik klikne button See more možemo i samo da se prebacimo na employee.html
// tada ajax poziv za dobavljanje jednog zaposlenog moze da bude u fajlu employee.js
$.ajax({
    type: "GET",
    url: "http://localhost:8080/api/clan/clan-neocenjeniTreninzi/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
    dataType: "json",
    success: function (data) {
    	for(i=0;i<data.length;i++){
    		var row="<tr class='sakrij'>";
    		row+="<td>"+data[i]['naziv']+"</td>";
    		row+="<td>"+data[i]['tipTreninga']+"</td>";
    		row+="<td>"+data[i]['opis']+"</td>";
    		row+="<td>"+data[i]['trajanje']+"</td>";
    		row+="<td>"+data[i]['srednjaOcena']+"</td>";
    		

   		 var btn = "<button class='btnOceni btn btn-danger' value="+data[i]['clanId']+"  id = " + data[i]['id'] + ">Oceni</button>";
             row += "<td>" + btn + "</td>"; 
             row+="</tr>";
             
	              
	              $('#tabela3').append(row);
	              
	              $("#neocenjeniTreninzi").removeClass("d-none").show();
	              
    	}                          
       
    },
    error: function (data) {
    	alert("Neuspešno, pokušajte opet!");
        console.log("ERROR : ", data);
    }
});
});



$(document).on('click', '.btnOceni', function () {        

	
	$.ajax({
		    type: "GET",
		    //uzimam podatke za clana i od te terminske liste
		url: "http://localhost:8080/api/clan/clan-oceniTrening/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
		dataType: "json",
		success: function (data){
			//alert("Uspešno ocenjen trening!");
			var red="<div class='input-group form-group'><div class='input-group-prepend'><span class='input-group-text'><i class='fa fa-film'></i></span></div>";
            red+="<input type='text' class='form-control' id='podatakOcena' placeholder='Izabrnai id' value="+data['id']+"  disabled='disabled'></div>"
             $('#treningic').append(red);
             $("#ocenjivanje").removeClass("d-none").show();
			 
			
		   
		},
		error: function (data) {
			alert("Neuspešno, pokušajte opet!");
			 window.location.href="prijava.html";
		    console.log("ERROR : ", data);
		    }
		});
});

$(document).on('click', '#oceniTrening', function () {            // kada je button (čija je class = btnSeeMore) kliknut
	event.preventDefault();
	
	
	var korisnickoIme=$("#korisnickoImeOcena").val();
	var lozinka=$("#lozinkaOcena").val();
	var ocena=$("#ocenaOcena").val();
	var id=$("#podatakOcena").val();
   
	var newKorisnikJSON=formToJSONOcena(korisnickoIme,lozinka,ocena,id);
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/clan/ocenjivanje",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(data){
			alert("Uspešno!");
			window.location.href="prijava.html";
			
			
		},
		error:function(data){
			
			alert("Greška!!");
			
        }
    });
});

function formToJSONOcena(korisnickoIme,lozinka,ocena,id){
	return JSON.stringify({
		"korisnickoIme":korisnickoIme,
		"lozinka":lozinka,
		"ocena":ocena,
		"id":id
		
	});
}