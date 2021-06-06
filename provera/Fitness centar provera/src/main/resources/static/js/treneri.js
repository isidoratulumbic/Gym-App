$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/treneri",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
			
				row+="<td>"+data[i]['korisnickoIme']+"</td>";
				row+="<td>"+data[i]['ime']+"</td>";
				row+="<td>"+data[i]['prezime']+"</td>";
			
				
				 var btn = "<button class='btnUkloni btn btn-danger' id = " + data[i]['id'] + ">Ukloni</button>";
	              row += "<td>" + btn + "</td>"; 
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#tabela').append(row);
	             $("#treneri").removeClass("d-none").show();

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
        url: "http://localhost:3050/api/treneru-ukloni/" + this.id,  // this.id je button id, a kao button id je postavljen id zaposlenog
        dataType: "json",
        success: function () {
        	alert("Uspesno uklonjen");
             window.location.href="treneri.html";                           
           
        },
        error: function (data) {
        	alert("Fitness centar ne sme ostati bez trenera, pokusajte opet");
            console.log("ERROR : ", data);
        }
    });
});