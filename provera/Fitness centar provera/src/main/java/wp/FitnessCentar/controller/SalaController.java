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
import wp.FitnessCentar.service.SalaService;

@RestController
@RequestMapping(value = "/api/sala") 
public class SalaController {

	
    private final SalaService salaService;
	

    // constructor-based dependency injection
    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }
    
    
   /*Dodavanje sale*/
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO) throws Exception {
        // Kreiramo objekat klase Employee, tako što za vrednosti atributa uzimamo
        // vrednosti iz primljenog DTO objekta
    	Sala sala = new Sala(salaDTO.getOznaka(), salaDTO.getKapacitet());

        // Pozivanjem metode servisa kreiramo novog zaposlenog
    	Sala newSala = salaService.create(sala);

        // Mapiramo novog zaposlenog na DTO objekat koji vraćamo kroz body odgovora
    	SalaDTO newSalaDTO = new SalaDTO(newSala.getId(), newSala.getOznaka(),
                newSala.getKapacitet());

        // Vraćamo odgovor 201 CREATED, a kroz body odgovora šaljemo podatke o novokreiranom
        // zaposlenom, uključujući i ID koji mu je dodeljen
        return new ResponseEntity<>(newSalaDTO, HttpStatus.CREATED);
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
    Metoda za brisanje postojećeg clana
 */
    /*
@DeleteMapping(value ="obrisi/{id}")
public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
    
    this.salaService.delete(id);

 
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}*/


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
    public ResponseEntity<Sala> sala1(@PathVariable(name="id") Long id){
    	Sala sala=this.salaService.findOne(id);
    	if(sala==null) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	Sala s = new Sala();
    	s.setId(sala.getId());
    	s.setOznaka(sala.getOznaka());
    	s.setKapacitet(sala.getKapacitet());
    //	s.setNaziv(sala.getFitness_centar().getNaziv());
    	
    	return new ResponseEntity<>(s,HttpStatus.OK);
    }
    @PostMapping(
    		value="/izmenjivanjeSALE",
    		consumes=MediaType.APPLICATION_JSON_VALUE,
    		produces=MediaType.APPLICATION_JSON_VALUE
    		)
    	public ResponseEntity<Sala> izmenaSALE(@RequestBody Sala s) throws Exception{
     Sala s1 = this.salaService.findOne(s.getId());
    		if(s1==null) {
    			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    		}
    		s1.setOznaka(s.getOznaka());
    		s1.setKapacitet(s.getKapacitet());
    		
    		this.salaService.saveSala(s1);
    		Sala ret = new Sala();
    		ret.setId(s1.getId());
    		return new ResponseEntity<>(ret,HttpStatus.OK);
    	}   
    
   
}