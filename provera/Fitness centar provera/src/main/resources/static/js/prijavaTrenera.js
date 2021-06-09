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
        url: "http://localhost:8080/api/trener/login",
        dataType: "json",
        type: "POST",
        contentType: "application/json",
        data: formData,
        success: function(data){

            sessionStorage.setItem("id", data["id"]);
            

            window.location.replace("/trenerNaslovna.html");
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
 