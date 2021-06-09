function prijava() {
    // get the form data
    // there are many ways to get this data using jQuery (you can use the class or id also)
    let korisnickoIme = document.getElementById('korisnickoIme').value;
    let lozinka = document.getElementById('lozinka').value;
    var formData = JSON.stringify({
        "korisnickoIme": korisnickoIme,
        "lozinka": lozinka
    });
    console.log(formData);
    
 $.ajax({
        url: "http://localhost:8080/api/clan/login",
        dataType: "json",
        type: "POST",
        contentType: "application/json",
        data: formData,
        success: function(data){

            sessionStorage.setItem("id", data["id"]);
            

            window.location.replace("/clanNaslovna.html");
        },
        error: function( jqXhr, textStatus, errorThrown ){
            if (jqXhr.status == 404) {
                alert("Email not found!");
                return;
            } else if (jqXhr.status == 400) {
                alert("Wrong password");
                return;
            } else if (jqXhr.status == 406) {
            	alert("Server error");
            	return;
            }
            // default handling
            alert("error")
        }
    });
} 
 


$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/clan",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
			
				row+="<td>"+data[i]['korisnickoIme']+"</td>";
				row+="<td>"+data[i]['lozinka']+"</td>";
				row+="<td>"+data[i]['ime']+"</td>";
				row+="<td>"+data[i]['prezime']+"</td>";
				row+="<td>"+data[i]['kontakt_telefon']+"</td>";
				row+="<td>"+data[i]['email']+"</td>";
				row+="<td>"+data[i]['datum_rodjenja']+"</td>";
				
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