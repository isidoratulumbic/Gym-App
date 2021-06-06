$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/fitnessCentar",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
			
				row+="<td>"+data[i]['naziv']+"</td>";
				row+="<td>"+data[i]['adresa']+"</td>";
				row+="<td>"+data[i]['broj_telefona_centrale']+"</td>";
				row+="<td>"+data[i]['email']+"</td>";
				
				 var btn = "<button class='btnTermini btn btn-danger' id = " + data[i]['id'] + ">Termini</button>";
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