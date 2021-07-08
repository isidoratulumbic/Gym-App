$(document).on("submit","form",function(event){
	event.preventDefault();
	$(".container").hide();
	
	
	var naziv=$("#naziv").val();
	var tipTreninga=$("#tipTreninga").val();
	var opis=$("#opis").val();
	var cena=$("#cena").val();
	var dan=$("#vreme").val();
	
	
	var newTreningJSON=formToJSON(naziv);
	
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/termin/poNazivu",
		dataType:"json",
		contentType:"application/json",
		data:newTreningJSON,
		success:function(data){
			for(i=0;i<data.length;i++){
				var row="<tr>";
				row+="<td>"+data[i]['dan']+"</td>";
				row+="<td>"+data[i]['vreme']+"</td>"
				row+="<td>"+data[i]['cena']+"</td>";
				row+="<td>"+data[i]['brojRezervacija']+"</td>"
				row+="<td>"+data[i]['naziv']+"</td>";
				row+="<td>"+data[i]['opis']+"</td>";
				row+="<td>"+data[i]['tipTreninga']+"</td>";
				row+="<td>"+data[i]['trajanje']+"</td>";
				
				 var btn = "<button class='rezervisi' id = " + data[i]['id'] + ">Rezerviši</button>";
	              row += "<td>" + btn + "</td>"; 
				
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
function formToJSON(dan,vreme,cena,brojRezervacija,naziv,opis,tipTeninga,trajanje){
	return JSON.stringify({
		"dan":dan,
		"vreme":vreme,
		"cena":cena,
		"brojRezervacija":brojRezervacija,
		"naziv":naziv,
		"opis":opis,
		"tipTreninga":tipTreninga,
		"trajanje":trajanje,
	});
}
	

	