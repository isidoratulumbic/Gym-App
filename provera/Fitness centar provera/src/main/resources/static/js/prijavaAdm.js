$(document).on("submit","form",function(event){
	event.preventDefault();
	var loginKartica=$("#kartica").hide();

	
		
	var korisnickoIme=$("#korisnickoIme").val();
	var lozinka=$("#lozinka").val();
	
	var newKorisnikJSON=formToJSON(korisnickoIme,lozinka);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/administrator/login",
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
			    rez="<button class='btnSale btn-outline-danger btn-lg btn-block' id="+data['id']+">Sale</button>";
				   
				  
				 $("#administrator").append(rez);
				  $("#administrator").removeClass("d-none").show();
			
		},
		error:function(data){
			var loginKartica=$("#kartica").show();
			alert("Greska! Administrator sa unetim podacima je nepostojeći");
		}
	});
	
});

function formToJSON(korisnickoIme,lozinka){
	return JSON.stringify({
		"korisnickoIme":korisnickoIme,
		"lozinka":lozinka
		
	});
}


function formToJSON(korisnickoIme,lozinka){
	return JSON.stringify({
		"korisnickoIme":korisnickoIme,
		"lozinka":lozinka
		
	});
}

$(document).on('click', '.btnSale', function () {            // kada je button (čija je class = btnSeeMore) kliknuti 
	$(".sakrij").empty();
	$("#Izmena-sala").hide();
	
	
	$.ajax({
		    type: "GET",
		url: "http://localhost:8080/api/administrator/sale/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
		dataType: "json",
		success: function (data) {
		
			for(i=0;i<data.length;i++){
				var row="<tr class='sakrij'>";
				row+="<td>"+data[i]['fitnessCentar']+"</td>";
				row+="<td>"+data[i]['oznaka']+"</td>";
				row+="<td>"+data[i]['kapacitet']+"</td>";
				
				var btn = "<button class='btnIzmeniSalu btn btn-danger' id = " + data[i]['id'] + ">Izmeni</button>";
				 row += "<td>" + btn + "</td>"; 
				var btn1 = "<button class='btnUkloniSalu btn btn-danger' id = " + data[i]['id'] + ">Ukloni</button>";
	            
	             row += "<td>" + btn1 + "</td>"; 
			
		
		        row+="</tr>";
		         
		        $('#tabela5').append(row);
				$("#sale").removeClass("d-none").show(); 
		             
		              
		             
		              
			} 
			var btn2 = "<a href='dodavanjeSale.html'><button class='btnDodajSalu btn btn-danger'>Dodaj novu salu</button></a>";
            
			row="<tr class='sakrij'><td colspan='5'>"+btn2+"</td></tr>";
			 $('#tabela5').append(row);
			$("#sale").removeClass("d-none").show();
			
		   
		},
		error: function (data) {
			alert("Nije  pronadjena ni jedna sala,pokušajte opet!!");
		    console.log("ERROR : ", data);
		    }
		});
});

$(document).on('click', '.btnUkloniSalu', function () {            // kada je button (čija je class = btnSeeMore) kliknuti
	
	$(".sakrij").empty();
	$("#Izmena-sala").hide();
	
	$.ajax({
		    type: "GET",
		url: "http://localhost:8080/api/administrator/saleUkloni/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
		dataType: "json",
		success: function (data){
			alert("Sala je uspešno obrisana!");
		    location.reload(true);         
			 
			
		   
		},
		error: function (data) {
			alert("Neuspešno, pokušajte opet!");
		    console.log("ERROR : ", data);
		    }
		});
});

