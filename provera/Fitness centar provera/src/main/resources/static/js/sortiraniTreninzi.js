$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/trening/sortNaziv",
		dataType:"json",
		success:function(data){
			console.log("SUCESS:",data);
			//SLIKAAAA !!!!!!
			for(i=0;i<data.length;i++){
				var col=" <div class=\" col-sm-6 col-lg-3\" style=\"float:left\">"
				col+="<a href='#' class='btnSlika' id=" + data[i]['id'] + "><img class=\"card-img-top\" src='images/"+data[i]['naziv']+".jpg' alt='Movie'></a>";
				col+="<div class=\"card-body\"> <h4 class=\"card-title\">"+data[i]['naziv']+"</h4>";
				col+="<p class=\"card-text\"><b>Naziv:</b>  <td>"+data[i]['naziv']+"</td>";
				col+="<br><b>Opis:</b> <td>"+data[i]['opis']+"</td>";
				col+="<br><b>Tip treninga:</b><td>"+data[i]['tip_treninga']+"</td>";
				col+="<br><b>Trajanje:</b><td>"+data[i]['trajanje']+"</td></p>";
				col+="</div></div></div>";
				
				$('#table').append(col);
			}
			
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

