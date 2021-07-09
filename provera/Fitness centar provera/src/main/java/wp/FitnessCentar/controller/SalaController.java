package wp.FitnessCentar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import wp.FitnessCentar.model.FitnessCentar;
import wp.FitnessCentar.model.Sala;
import wp.FitnessCentar.model.dto.FitnessCentarDTO;
import wp.FitnessCentar.model.dto.SalaDTO;
import wp.FitnessCentar.service.FitnessCentarService;
import wp.FitnessCentar.service.SalaService;

@RestController
@RequestMapping(value = "/api/sala") 
public class SalaController {

	@Autowired
	private FitnessCentarService fitnessCentarService;
    private final SalaService salaService;
	

    // constructor-based dependency injection
    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }
    
    
   /*Dodavanje sale*/
    
    @PostMapping(
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SalaDTO> dodaj(@RequestBody SalaDTO s) throws Exception	{
			FitnessCentar f=this.fitnessCentarService.findNaziv(s.getFitnessCentar());
			if(f==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				Sala sala=new Sala(s.getOznaka(), s.getKapacitet(), f);
				Sala newSala=this.salaService.save(sala);
				
				SalaDTO salaDTO=new SalaDTO(newSala.getId(), newSala.getOznaka(), newSala.getKapacitet(), newSala.getFitness_centar().getNaziv());
				return new ResponseEntity<>(salaDTO,HttpStatus.OK);
			}
		}
    
   /*dobavljanje 1 sale
    	     -----------------*/
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> getSala(@PathVariable("id") Long id) {
        
    	Sala sala = this.salaService.findOne(id);

       
    	SalaDTO salaDTO = new SalaDTO();
    	
    	salaDTO.setId(sala.getId());
    	salaDTO.setOznaka(sala.getOznaka());
    	salaDTO.setKapacitet(sala.getKapacitet());
    	
        
        
        return new ResponseEntity<>(salaDTO, HttpStatus.OK);
        }
    	     
   
    
    /*
    Metoda za dobavljanje svih sala
*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SalaDTO>> getFitnessCentri() {
		   
		    List<Sala> salaList = this.salaService.findAll();

		    
		    List<SalaDTO> salaDTOS = new ArrayList<>();

		    for (Sala sala : salaList) {
		        
		    	SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getOznaka(),
		    			sala.getKapacitet(),sala.getFitness_centar().getNaziv());
		    	salaDTOS.add(salaDTO);
		    }

		    
		    return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
		}
    
    


    /*
    Metoda za brisanje postojeće sale
 */

    @GetMapping(
    		value="obrisi/{id}",
    		produces = MediaType.APPLICATION_JSON_VALUE)
    		public ResponseEntity<SalaDTO> obrisi(@PathVariable(name="id") Long id){
    			Sala sala=this.salaService.findOne(id);
    			
    			SalaDTO s=new SalaDTO(sala.getId(),sala.getOznaka(),sala.getKapacitet(),sala.getFitness_centar().getNaziv());
    			this.salaService.delete(id);
    			
    			return new ResponseEntity<>(s,HttpStatus.OK);
    		}
    
    /*Izmenjivanje sale*/
  @GetMapping(
			value="izmeniSALU/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalaDTO> salaIzmena(@PathVariable(name="id") Long id){
		Sala s=this.salaService.findOne(id);
		SalaDTO s1=new SalaDTO();
		s1.setId(s.getId());
		s1.setKapacitet(s.getKapacitet());
		s1.setOznaka(s.getOznaka());
		s1.setFitnessCentar(s.getFitness_centar().getNaziv());
		return new ResponseEntity<>(s1,HttpStatus.OK);
	}
  
    @PostMapping(
    		value="/izmenjivanjeSALE",
    		consumes=MediaType.APPLICATION_JSON_VALUE,
    		produces=MediaType.APPLICATION_JSON_VALUE
    		)
    	public ResponseEntity<Sala> izmenaSALE(@RequestBody Sala s) throws Exception{
     Sala fc = this.salaService.findOne(s.getId());
    		if(fc==null) {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    		fc.setOznaka(s.getOznaka());
    		fc.setKapacitet(s.getKapacitet());
    		
    		this.salaService.saveSala(fc);
    		Sala ret = new Sala();
    		ret.setId(fc.getId());
    		return new ResponseEntity<>(ret,HttpStatus.OK);
    	}
	
    


}