$(document).on("submit","form",function(event){
	event.preventDefault();
	
	
	let naziv=$("#naziv").val();
	let TipTreninga=$("#tipTreninga").val();
	let opis=$("#opis").val();
	let cena=$("#cena").val();
	let vreme=$("#vreme").val();
	
	
	if(cena==""){
		cena=1000;
		}
	if(vreme==""){
		vreme=new Date().toISOString();
		}
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/termin/pretraga?cena="+cena+"&vreme="+vreme+"&naziv="+naziv+"&opis="+opis+"&tipTreninga="+tipTreninga,
		dataType:"json",                                       // tip povratne vrednosti
        success: function (response) { 
        console.log("SUCCESS: \n.response)
        console.log(response);                             // ova f-ja se izvršava posle uspešnog zahteva
        
        $('.content-table tbody').html("");
        
         for(let termin of response){
        		let row="<tr>";
        		row+="<td>" +termin.id+"</td>";
        		row+="<td>" +termin.naziv+"</td>";
        		row+="<td>"+termin.tipTreninga+"</td>";
        		row+="<td>"+termin.opis+"</td>";
        		row+="<td>"+ new Date (termin.vreme).toLocaleString() + "</td>";
        		row+="<td>"++termin.trajanje+"</td>";
        		row+="<td>"+termin.cena+"</td>";
        		
				var btn = "<button class='btnRezerviši btn btn-danger' value="+data[i]['clanId']+" id= " + data[i]['id']+ ">Rezerviši</button>";
	              row += "<td>" + btn + "</td>"; 
				$('#termini').append(row);
			}
			
		},
		error:function(data){
			alert("Nema pronadjenih treninga!");
			window.location.href="pretraga.html";
			
		}
		
	});
	
});

function formToJSON(naziv,tipTreninga,opis,cena,vreme){
	return JSON.stringify({
		"naziv":naziv,
		"tipTreninga":tipTreninga,
		"opis":opis,
		"cena":cena,
		"vreme":vreme
	});
}
	