$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/trener",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
			
				row+="<td>"+data[i]['korisnickoIme']+"</td>";
				row+="<td>"+data[i]['ime']+"</td>";
				row+="<td>"+data[i]['prezime']+"</td>";
				row+="<td>"+data[i]['kontakt_telefon']+"</td>";
				row+="<td>"+data[i]['datum_rodjenja']+"</td>";
				row+="<td>"+data[i]['uloga']+"</td>";
				
				 var btn = "<button class='ukloniTrenera' id = " + data[i]['id'] + ">Ukloni</button>";
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

//Brisanje trenera
$(document).on('click', '.ukloniTrenera', function () {       
    

 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/trener/ukloni/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	alert("Trener je uspešno uklonjen!");
        	location.reload(true); //osvezavanje tabele odmah nakon brisanja
                           
           
        },
        error: function (data) {
        	alert("Došlo je do greške!");
            console.log("ERROR : ", data);
        }
    });
});


