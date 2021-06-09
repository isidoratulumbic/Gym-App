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
import wp.FitnessCentar.model.dto.TerminDTO;
import wp.FitnessCentar.service.TerminService;



@RestController
@RequestMapping(value = "/api/termin") 
public class TerminController {

    private final TerminService terminService; 

    // constructor-based dependency injection
    @Autowired
    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }
    
    /*
    Metoda za dobavljanje svih termina

*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini() {
       
        List<Termin> terminList = this.terminService.findAll();

        
        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminList) {
            
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getDan(),
                    termin.getVreme(), termin.getCena(), termin.getBrojRezervacija());
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    
    /*Sortiranje treninga po ceni
     * 
     */
   @GetMapping(
			value="/sortCena",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TerminDTO>> sortCena(){
		List<Termin> termini=this.terminService.orderCena();
	
		
		List<TerminDTO> terminiDTO=new ArrayList<>();
		
		for(Termin termin:termini) {
			TerminDTO terminDTO=new TerminDTO(termin.getId(),termin.getDan(),termin.getVreme(),termin.getCena(),termin.getBrojRezervacija());
			terminiDTO.add(terminDTO);
		}
		return new ResponseEntity<>(terminiDTO,HttpStatus.OK);
	}
}
