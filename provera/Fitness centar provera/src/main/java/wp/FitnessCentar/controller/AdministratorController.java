package wp.FitnessCentar.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wp.FitnessCentar.model.Administrator;
import wp.FitnessCentar.model.Administrator;
import wp.FitnessCentar.model.Administrator;
import wp.FitnessCentar.model.dto.AdministratorDTO;
import wp.FitnessCentar.model.dto.AdministratorDTOPrijava;
import wp.FitnessCentar.model.dto.AdministratorDTOReg;
import wp.FitnessCentar.model.dto.ClanDTOPrijava;
import wp.FitnessCentar.service.AdministratorService;

@RestController
@RequestMapping(value = "/api/administrator") 
public class AdministratorController {

    private final AdministratorService administratorService; 

    // constructor-based dependency injection
    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }
    
    @GetMapping("/pocetna")
    public String welcome() {
        return "pocetna.html";
	}
    
    /*dobavljanje 1 administratora
     -----------------*/
     
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorDTO> getAdministrator(@PathVariable("id") Long id) {
        
    	Administrator administrator = this.administratorService.findOne(id);

       
    	AdministratorDTO administratorDTO = new AdministratorDTO();
    	administratorDTO.setId(administrator.getId());
    	administratorDTO.setKorisnickoIme(administrator.getKorisnickoIme());
    	administratorDTO.setIme(administrator.getIme());
    	administratorDTO.setPrezime(administrator.getPrezime());
    	administratorDTO.setKontakt_telefon(administrator.getKontakt_telefon());
    	administratorDTO.setDatum_rodjenja(administrator.getDatum_rodjenja());
    	administratorDTO.setUloga(administrator.getUloga());
        
        return new ResponseEntity<>(administratorDTO, HttpStatus.OK);
        }
        
    /*
    Metoda za dobavljanje svih administratora
*/
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<AdministratorDTO>> getAdministratori() {
   
    List<Administrator> administratorList = this.administratorService.findAll();

    
    List<AdministratorDTO> administratorDTOS = new ArrayList<>();

    for (Administrator administrator: administratorList) {
        
    	AdministratorDTO administratorDTO = new AdministratorDTO(administrator.getId(), administrator.getKorisnickoIme(),
    			administrator.getIme(), administrator.getPrezime(),administrator.getKontakt_telefon(),administrator.getDatum_rodjenja(),administrator.getUloga());
    	administratorDTOS.add(administratorDTO);
    }

    
    return new ResponseEntity<>(administratorDTOS, HttpStatus.OK);
}

/*
 * Registracija novog administratora
 */
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<AdministratorDTOReg> createAdministrator(@RequestBody AdministratorDTOReg administratorDTOReg) throws Exception {
	
Administrator administrator = new Administrator(administratorDTOReg.getKorisnickoIme(), administratorDTOReg.getLozinka(),
		administratorDTOReg.getIme(),administratorDTOReg.getPrezime(), administratorDTOReg.getKontakt_telefon(),administratorDTOReg.getEmail(),administratorDTOReg.getDatum_rodjenja(),administratorDTOReg.getUloga());


Administrator newAdministrator = administratorService.create(administrator);


AdministratorDTOReg newAdministratorDTOReg = new AdministratorDTOReg(newAdministrator.getId(), newAdministrator.getKorisnickoIme(),
  newAdministrator.getLozinka(), newAdministrator.getIme(), newAdministrator.getPrezime(),newAdministrator.getKontakt_telefon(),newAdministrator.getEmail(),newAdministrator.getDatum_rodjenja(),newAdministrator.getUloga());


return new ResponseEntity<>(newAdministratorDTOReg, HttpStatus.CREATED);
}
    
/*
    Metoda za brisanje postojećeg administratora
 */
@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
    
    this.administratorService.delete(id);

 
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}


@PostMapping("/login")
public ResponseEntity<?> prijava(@RequestBody AdministratorDTOPrijava administratorDTOPrijava) {
	Administrator administrator;
	try {
		administrator=this.administratorService.checkKorisnickoIme(administratorDTOPrijava);
	} catch (Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	if(administrator==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	if(!(this.administratorService.prijava(administratorDTOPrijava, administrator))) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<Administrator>(administrator, HttpStatus.OK);
}
@GetMapping("/profilAdministratora/{id}")
public String account(@PathVariable(name = "id") Long id,Model model) {
	Administrator administrator=this.administratorService.findOne(id);
	model.addAttribute("administrator", administrator);
	return "administratorNaslovna.html";
}
}