// Prikaz svih treninga
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih treninga sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/termin",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";               
                row += "<td>" + termin.naziv + "</td>";
                row += "<td>" + termin.opis + "</td>";
                row += "<td>" + termin.tipTreninga + "</td>";      
                row += "<td>" + termin.trajanje + "</td>";                // kreiramo red za tabelu
                row += "<td>" + termin.dan + "</td>";   
                row += "<td>" + termin.vreme + "</td>";    // ubacujemo podatke jednog treninga u polja
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.brojRezervacija + "</td>";
               
                // kreiramo button i definisemo custom data atribut id = id treninga
                let btn = "<button class='btnRezerviši' data-id=" + termin.id + ">Rezerviši</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#termini').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = treninzi
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});



// Sortiranje termina po ceni
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih treninga sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/termin/sortCena",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                                // kreiramo red za tabelu
                row += "<td>" + termin.dan + "</td>";   
                row += "<td>" + termin.vreme + "</td>";    // ubacujemo podatke jednog treninga u polja
                row += "<td>" + termin.cena + "</td>";
                row += "<td>" + termin.brojRezervacija + "</td>";
                // kreiramo button i definisemo custom data atribut id = id treninga
                let btn = "<button class='btnRezerviši' data-id=" + termin.id + ">Rezerviši</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#sorttermini').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = treninzi
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});