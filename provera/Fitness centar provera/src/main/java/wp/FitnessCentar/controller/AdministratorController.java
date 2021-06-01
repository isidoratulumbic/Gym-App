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
import wp.FitnessCentar.model.dto.AdministratorDTO;
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
    
    /*dobavljanje 1 administrator
     -----------------*/
     
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorDTO> getAdministrator(@PathVariable("id") Long id) {
        
    	Administrator administrator = this.administratorService.findOne(id);

       
    	AdministratorDTO administratorDTO = new AdministratorDTO();
    	administratorDTO.setId(administrator.getId());
    	administratorDTO.setKorisnicko_ime(administrator.getKorisnicko_ime());
    	administratorDTO.setIme(administrator.getIme());
    	administratorDTO.setPrezime(administrator.getPrezime());
    	administratorDTO.setKontakt_telefon(administrator.getKontakt_telefon());
    	administratorDTO.setDatum_rodjenja(administrator.getDatum_rodjenja());
    	administratorDTO.setUloga(administrator.getUloga());
        
        return new ResponseEntity<>(administratorDTO, HttpStatus.OK);
        }
        
    /*
    Metoda za dobavljanje svih administratora
  -----------------------------------------
*/
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<AdministratorDTO>> getAdministratori() {
   
    List<Administrator> administratorList = this.administratorService.findAll();

    
    List<AdministratorDTO> administratorDTOS = new ArrayList<>();

    for (Administrator administrator: administratorList) {
        
    	AdministratorDTO administratorDTO = new AdministratorDTO(administrator.getId(), administrator.getKorisnicko_ime(),
    			administrator.getIme(), administrator.getPrezime(),administrator.getKontakt_telefon(),administrator.getDatum_rodjenja(),administrator.getUloga());
    	administratorDTOS.add(administratorDTO);
    }

    
    return new ResponseEntity<>(administratorDTOS, HttpStatus.OK);
}

    //registracija novog administratora
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator a) throws Exception {
        
    	Administrator administrator = new Administrator(a.getKorisnicko_ime(), a.getLozinka(),
                a.getIme(),  a.getPrezime(),  a.getKontakt_telefon(), a.getEmail(),  a.getDatum_rodjenja(), a.getUloga());

        
    	Administrator newAdministrator = administratorService.create(administrator);

     
        return new ResponseEntity<>(newAdministrator, HttpStatus.CREATED);
    }
    
/*
    Metoda za brisanje postojećeg administratora
 */
@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
    
    this.administratorService.delete(id);

 
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}