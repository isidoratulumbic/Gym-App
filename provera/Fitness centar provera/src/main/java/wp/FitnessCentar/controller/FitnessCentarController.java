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



import wp.FitnessCentar.model.Administrator;
import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.FitnessCentar;
import wp.FitnessCentar.model.dto.ClanDTOReg;
import wp.FitnessCentar.model.dto.FitnessCentarDTO;

import wp.FitnessCentar.service.AdministratorService;
import wp.FitnessCentar.service.FitnessCentarService;

@RestController
@RequestMapping(value = "/api/fitnessCentar") 
public class FitnessCentarController {

	
    private final FitnessCentarService fitnessCentarService; 

    // constructor-based dependency injection
    @Autowired
    public FitnessCentarController(FitnessCentarService fitnessCentarService) {
        this.fitnessCentarService = fitnessCentarService;
    }
    
    
   /*Dodavanje FC*/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> createFitnessCentar(@RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception {
        // Kreiramo objekat klase Employee, tako što za vrednosti atributa uzimamo
        // vrednosti iz primljenog DTO objekta
    	FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getNaziv(), fitnessCentarDTO.getAdresa(),
    			fitnessCentarDTO.getBroj_telefona_centrale(),fitnessCentarDTO.getEmail());

        // Pozivanjem metode servisa kreiramo novog zaposlenog
    	FitnessCentar newFitnessCentar = fitnessCentarService.create(fitnessCentar);

        // Mapiramo novog zaposlenog na DTO objekat koji vraćamo kroz body odgovora
    	FitnessCentarDTO newFitnessCentarDTO = new FitnessCentarDTO(newFitnessCentar.getId(), newFitnessCentar.getNaziv(),
                newFitnessCentar.getAdresa(), newFitnessCentar.getBroj_telefona_centrale(),newFitnessCentar.getEmail());

        // Vraćamo odgovor 201 CREATED, a kroz body odgovora šaljemo podatke o novokreiranom
        // zaposlenom, uključujući i ID koji mu je dodeljen
        return new ResponseEntity<>(newFitnessCentarDTO, HttpStatus.CREATED);
    }
    
   /*dobavljanje 1 FC
    	     -----------------*/
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> getFitnessCentar(@PathVariable("id") Long id) {
        
    	FitnessCentar fitnessCentar = this.fitnessCentarService.findOne(id);

       
    	FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO();
    	
    	fitnessCentarDTO.setId(fitnessCentar.getId());
    	fitnessCentarDTO.setNaziv(fitnessCentar.getNaziv());
    	fitnessCentarDTO.setAdresa(fitnessCentar.getAdresa());
    	fitnessCentarDTO.setBroj_telefona_centrale(fitnessCentar.getBroj_telefona_centrale());
    	fitnessCentarDTO.setEmail(fitnessCentar.getEmail());
        
        
        return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.OK);
        }
    	     
   
    
    /*
    Metoda za dobavljanje svih FC
*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FitnessCentarDTO>> getFitnessCentri() {
		   
		    List<FitnessCentar> fitnessCentarList = this.fitnessCentarService.findAll();

		    
		    List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();

		    for (FitnessCentar fitnessCentar : fitnessCentarList) {
		        
		    	FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fitnessCentar.getId(), fitnessCentar.getNaziv(),
		    			fitnessCentar.getAdresa(), fitnessCentar.getBroj_telefona_centrale(),fitnessCentar.getEmail());
		    	fitnessCentarDTOS.add(fitnessCentarDTO);
		    }

		    
		    return new ResponseEntity<>(fitnessCentarDTOS, HttpStatus.OK);
		}
    
    /*
    Metoda za brisanje postojećeg FC
 */
@GetMapping(
		value="fitnessCentri/obrisi/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<FitnessCentarDTO> obrisi(@PathVariable(name="id") Long id){
			FitnessCentar fitnessCentar=this.fitnessCentarService.findOne(id);
			
			FitnessCentarDTO fc=new FitnessCentarDTO(fitnessCentar.getId(),fitnessCentar.getNaziv(),fitnessCentar.getAdresa(),fitnessCentar.getBroj_telefona_centrale(),fitnessCentar.getEmail());
			this.fitnessCentarService.delete(id);
			
			return new ResponseEntity<>(fc,HttpStatus.OK);
		}
/*
 * Izmena FC
 * 
 */


@GetMapping(
		value="izmeniFC/{id}",
		produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<FitnessCentar> sala(@PathVariable(name="id") Long id){
	FitnessCentar fitnessCentar=this.fitnessCentarService.findOne(id);
	if(fitnessCentar==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	FitnessCentar b = new FitnessCentar();
	b.setId(fitnessCentar.getId());
	b.setNaziv(fitnessCentar.getNaziv());
	b.setAdresa(fitnessCentar.getAdresa());
	b.setEmail(fitnessCentar.getEmail());
	b.setBroj_telefona_centrale(fitnessCentar.getBroj_telefona_centrale());
	
	return new ResponseEntity<>(b,HttpStatus.OK);
}
@PostMapping(
		value="/izmenjivanjeFC",
		consumes=MediaType.APPLICATION_JSON_VALUE,
		produces=MediaType.APPLICATION_JSON_VALUE
		)
	public ResponseEntity<FitnessCentar> izmenaFC(@RequestBody FitnessCentar b) throws Exception{
 FitnessCentar fc = this.fitnessCentarService.findOne(b.getId());
		if(fc==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		fc.setNaziv(b.getNaziv());
		fc.setAdresa(b.getAdresa());
		fc.setBroj_telefona_centrale(b.getBroj_telefona_centrale());
		fc.setEmail(b.getEmail());
		this.fitnessCentarService.saveFitnessCentar(fc);
		FitnessCentar ret = new FitnessCentar();
		ret.setId(fc.getId());
		return new ResponseEntity<>(ret,HttpStatus.OK);
	}

}


    