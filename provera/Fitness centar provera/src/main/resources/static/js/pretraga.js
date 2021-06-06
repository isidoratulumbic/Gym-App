$(document).ready(function(){
    $("#pretrazeno").hide();
});


$(document).on("submit","form",function(event){
	event.preventDefault();
	$(".container").hide();
	var naziv=$("#naziv").val();
	var tipTreninga=$("#tipTreninga").val();
	var opis=$("#opis").val();
	var cena=$("#cena").val();
	var dan=$("#dan").val();
	
	
	var newTreningJSON=formToJSON(naziv,tipTreninga,opis,cena,dan);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/trening/pretragaTreninga",
		dataType:"json",
		contentType:"application/json",
		data:newTreningJSON,
		success:function(data){
			for(i=0;i<data.length;i++){
				var row="<tr>";
				row+="<td>"+data[i]['naziv']+"</td>";
				row+="<td>"+data[i]['tipTreninga']+"</td>"
				row+="<td>"+data[i]['opis']+"</td>";
				row+="<td>"+data[i]['cena']+"</td>"
				row+="<td>"+data[i]['dan']+"</td>";
				
				
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#pretrazeno').append(row);
				
			}
			
			$("#pretrazeno").show();
		},
		error:function(data){
			alert("Nema pronadjenih treninga!");
			window.location.href="pretraga.html";
		}
	});
	
});

//pomocna funkcija koja od polja praavi JSON
function formToJSON(naziv,opis,tipTreninga,dan,cena){
	return JSON.stringify({
		"naziv":naziv,
		"opis":opis,
		"tipTreninga":tipTreninga,
		"dan":dan,
		"cena":cena
	});
}
	

	