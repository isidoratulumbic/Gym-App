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
import wp.FitnessCentar.model.FitnessCentar;
import wp.FitnessCentar.model.dto.FitnessCentarDTOAdd;
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
    @Autowired
	private AdministratorService administratorService;
    
    /*Dodavanje Fitness Centra od strane administratora
     * 
     */
    @PostMapping(
    		consumes=MediaType.APPLICATION_JSON_VALUE,
    		produces=MediaType.APPLICATION_JSON_VALUE)
    	public ResponseEntity<FitnessCentarDTOAdd> dodaj(@RequestBody FitnessCentarDTOAdd f) throws Exception	{
    	FitnessCentar fitnessCentar=new FitnessCentar(f.getNaziv(), f.getAdresa(), f.getBroj_telefona_centrale(), f.getEmail());
    		String a=f.getAdministrator();
    		Administrator administrator=this.administratorService.findByKorisnickoIme(a);
    	
    		if(administrator==null) {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    		else {
    			fitnessCentar.setAdministrator(administrator);
    			this.fitnessCentarService.save(fitnessCentar);
    			
    			FitnessCentarDTOAdd fitnessCentarDTO=new FitnessCentarDTOAdd(fitnessCentar.getId(),fitnessCentar.getNaziv(),fitnessCentar.getAdresa(),fitnessCentar.getBroj_telefona_centrale(),fitnessCentar.getEmail());
    			return new ResponseEntity<>(fitnessCentarDTO,HttpStatus.OK);
    		}
    		
    		
    	}
    
    
    
    
    
    
    
}



    