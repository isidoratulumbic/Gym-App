function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("Treninzi");
  switching = true;
  dir = "asc";
  var thead=document.getElementById("th"+n);
  thead.classList.add('fa-sort-asc');
  while (switching) {
    switching = false;
    rows = table.rows;
    for (i = 1; i < (rows.length - 1); i++) {
      shouldSwitch = false;
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          shouldSwitch = true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      switchcount ++;
    } else {
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        thead.classList.remove('fa-sort-asc');
        thead.classList.add('fa-sort-desc');
        switching = true;
      }
    }
  }
 	for (i = 1; i <6 ; i++)
 	{
 		var trows=document.getElementById("th"+i);
 		if(i!=n)
 		{
 			if(trows.classList.contains('fa-sort-asc')){
 				trows.classList.remove('fa-sort-asc');
 			} else if(trows.classList.contains('fa-sort-desc')){
 			trows.classList.remove('fa-sort-desc');
 			}
 		}
 	}
}

function filterData(treninziDTO)
{
	var naziv=document.getElementById("naziv").value;
	var tipTreninga=document.getElementById("tipTreninga").value;
	var vreme=document.getElementById("vreme").value;
	var opis=document.getElementById("opis").value;
	var ocena=document.getElementById("cena").value;
	var filter=[];
	var treninzi=treninziDTO.treninzi;
	for(let i=0;i<treninzi.length;i++)
	{
		document.getElementById(treninzi[i].id).style.display="";
	}
	if(naziv!="")
		filter["naziv"]=nazvi;
		
	if(tipTreninga!="TipTreninga")
		filter["tipTreninga"]=tipTreninga;
		
		
	if(opis!="")
		filter["opis"]=opis;
		
		
	if(cena!="")
		filter["cena"]=cena;
		
		
	if(vreme!="")
		filter["vreme"]=vreme;
	for (const [key, value] of Object.entries(filter)) {
		filterOne(treninzi,key,value);
	}
}

function filterOne(treninzi,key,value)
{
	for(let i=0;i<treninzi.length;i++)
	{
		finalFilter(treninzi[i],key,value);
	}
}

function finalFilter(trening,key,value)
{
	if(document.getElementById(trening.id).style.display=="none")
	{
		return;
	}
	let flag=false;
	if(key=="cena"){
		for(let i=0;i<trening.termini.length;i++){
			if(parseInt(value)>=trening.projections[i].cena)
				flag=true;
		}
	}
	else if(key=="vreme"){
		let help=value.split(":");
		for(let i=0;i<trening.termini.length;i++)
		{
			let arr=trening.termini[i].time.split(":");
			if(parseInt(help[0])>=parseInt(arr[0]))
			{
				if(parseInt(help[1])>=parseInt(arr[1]))
					flag=true;	
			}	
		}
	}
	else if(key=="naziv"){
		if(trening.naziv.toLowerCase().indexOf(value.toLowerCase())>-1)
			flag=true;
	}else if(key=="opis"){
		if(trening.opis.toLowerCase().indexOf(value.toLowerCase())>-1)
			flag=true;
	}else if(key=="tipTreninga"){
		if(value!="TipTreninga")
		{
			if(trening.tipTreninga==value)
				flag=true;
		}
		else
			flag=true;
	}
	
	if(flag){
		document.getElementById(trening.id).style.display="";
	}
	else{
		document.getElementById(trening.id).style.display="none";
	}
	
	
}

function getTrening(id) {
    $.ajax({
        url: '/treninzi/'+id,
        type: 'get',
        contentType: 'application/json',
        success: function(){
            window.location.replace("/trening/"+id);
        },
        error: function(){
            	alert("Server error");
            	return;
        }
    });
}

