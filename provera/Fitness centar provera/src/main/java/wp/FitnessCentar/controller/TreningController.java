package wp.FitnessCentar.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wp.FitnessCentar.model.Termin;
import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.model.dto.TreningDTO;
import wp.FitnessCentar.service.ClanService;
import wp.FitnessCentar.service.TerminService;
import wp.FitnessCentar.service.TreningService;

@RestController
@RequestMapping(value = "/api/trening") 
public class TreningController {

    private final TreningService treningService; 

    // constructor-based dependency injection
    @Autowired
    public TreningController(TreningService treningService) {
        this.treningService = treningService;
    }
    @Autowired
	private TerminService terminService;
    
    /*
    Metoda za dobavljanje svih treninga
    -pregled treninga-
  -----------------------------------------
*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi() {
       
        List<Trening> treningList = this.treningService.findAll();

        
        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Trening trening : treningList) {
            
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                    trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje(),trening.getSrednja_ocena());
            treningDTOS.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }
    
    /*Dodavanje treninga
     * 
     */
    @PostMapping(
			value="/dodavanjeTreninga",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trening> dodaj(@RequestBody TreningDTO t)throws Exception{
		Trening trening=new Trening();
		trening.setNaziv(t.getNaziv());
		trening.setOpis(t.getOpis());
		trening.setTipTreninga(t.getTipTreninga());
		trening.setTrajanje(t.getTrajanje());
		Double o=Double.parseDouble("0");
		trening.setSrednja_ocena(o);
		this.treningService.save(trening);
		
		return new ResponseEntity<>(trening,HttpStatus.OK);
	}
    
    /*Sortiranje treninga po nazivu
     * 
     */
    @GetMapping(
			value="/sortNaziv",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TreningDTO>> sortNaziv(){
		List<Trening> treninzi=this.treningService.orderNaziv();
	
		
		List<TreningDTO> treninziDTO=new ArrayList<>();
		
		for(Trening trening:treninzi) {
			TreningDTO treningDTO=new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getTipTreninga(),trening.getTrajanje(),trening.getSrednja_ocena());
			treninziDTO.add(treningDTO);
		}
		return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
	}
    
    /*Sortiranje treninga po tipu
     * 
     */
    @GetMapping(
			value="/sortTip",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TreningDTO>> sortTip(){
		List<Trening> treninzi=this.treningService.orderTip();
	
		
		List<TreningDTO> treninziDTO=new ArrayList<>();
		
		for(Trening trening:treninzi) {
			TreningDTO treningDTO=new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getTipTreninga(),trening.getTrajanje(),trening.getSrednja_ocena());
			treninziDTO.add(treningDTO);
		}
		return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
	}
    
    /*Sortiranje treninga po opisu
     * 
     */
    @GetMapping(
			value="/sortOpis",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TreningDTO>> sortOpis(){
		List<Trening> treninzi=this.treningService.orderOpis();
	
		
		List<TreningDTO> treninziDTO=new ArrayList<>();
		
		for(Trening trening:treninzi) {
			TreningDTO treningDTO=new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getTipTreninga(),trening.getTrajanje(),trening.getSrednja_ocena());
			treninziDTO.add(treningDTO);
		}
		return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
	}
    
    
    /*Sortiranje treninga po ceni
     * 
     */
   /* @GetMapping(
			value="/sortCena",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TreningDTO>> sortCena(){
		List<Trening> treninzi=this.treningService.orderCena();
	
		
		List<TreningDTO> treninziDTO=new ArrayList<>();
		
		for(Trening trening:treninzi) {
			TreningDTO treningDTO=new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getTipTreninga(),trening.getTrajanje(),trening.getSrednja_ocena());
			treninziDTO.add(treningDTO);
		}
		return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
	}*/
    
    /*Sortiranje treninga po vremenu termina
     * 
     */
  /*  @GetMapping(
			value="/sortVreme",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TreningDTO>> sortVreme(){
		List<Trening> treninzi=this.treningService.orderVreme();
	
		
		List<TreningDTO> treninziDTO=new ArrayList<>();
		
		for(Trening trening:treninzi) {
			TreningDTO treningDTO=new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getTipTreninga(),trening.getTrajanje(),trening.getSrednja_ocena());
			treninziDTO.add(treningDTO);
		}
		return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
	}
    
    */
    
    /*Pretraga treninga po kriterijumima*/
     
    @PostMapping(
			value="/pretragaTreninga",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trening>> pretraga(Trening t)throws Exception{
    	
			List <Termin> termini = this.terminService.findAll();
			List<Trening> treninzi = new ArrayList<>();
			//boolean puno = false; //ukoliko ostane na false znaci da nijedno polje nije popunjeno
			
			for(Termin a:termini)
			{
				if(t.getNaziv()!="")
					if(a.getTrening().getNaziv().equalsIgnoreCase(t.getNaziv()))
					{
						treninzi.add(a.getTrening());
						
						continue;
					}
				if(t.getTipTreninga()!="")
					if(a.getTrening().getTipTreninga().equalsIgnoreCase(t.getTipTreninga()))
					{
						treninzi.add(a.getTrening());
						continue;
					}
				if(t.getOpis()!="")
					if(a.getTrening().getOpis().equalsIgnoreCase(t.getOpis()))
					{
						treninzi.add(a.getTrening());
						continue;
					}
			
    
				
				
			/*	if(f.getCena()!=0)
					if(p.getTrening().getCena()==(f.getCena()))
					{
						treninzi.add(p.getTrening());
						return new ResponseEntity<>(treninzi,HttpStatus.OK);
				
				
				
			}*/
			if(treninzi.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			return new ResponseEntity<>(treninzi,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
}