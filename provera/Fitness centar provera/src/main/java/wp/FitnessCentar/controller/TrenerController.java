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


import wp.FitnessCentar.model.Trener;
import wp.FitnessCentar.model.dto.TrenerDTO;
import wp.FitnessCentar.service.TrenerService;

@RestController
@RequestMapping(value = "/api/trener") 
public class TrenerController {

    private final TrenerService trenerService; 

    // constructor-based dependency injection
    @Autowired
    public TrenerController(TrenerService trenerService) {
        this.trenerService = trenerService;
    }
    
    /*dobavljanje 1 clana
     -----------------*/
     
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> getTrener(@PathVariable("id") Long id) {
        
    	Trener trener = this.trenerService.findOne(id);

       
    	TrenerDTO trenerDTO = new TrenerDTO();
        trenerDTO.setId(trener.getId());
        trenerDTO.setKorisnickoIme(trener.getKorisnickoIme());
        trenerDTO.setIme(trener.getIme());
        trenerDTO.setPrezime(trener.getPrezime());
        trenerDTO.setKontakt_telefon(trener.getKontakt_telefon());
        trenerDTO.setDatum_rodjenja(trener.getDatum_rodjenja());
        trenerDTO.setUloga(trener.getUloga());
        
        return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
        }
        
    /*
    Metoda za dobavljanje svih clanova
  -----------------------------------------
*/
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TrenerDTO>> getTreneri() {
   
    List<Trener> trenerList = this.trenerService.findAll();

    
    List<TrenerDTO> trenerDTOS = new ArrayList<>();

    for (Trener trener : trenerList) {
        
    	TrenerDTO trenerDTO = new TrenerDTO(trener.getId(), trener.getKorisnickoIme(),
    			trener.getIme(), trener.getPrezime(),trener.getKontakt_telefon(),trener.getDatum_rodjenja(),trener.getUloga());
       trenerDTOS.add(trenerDTO);
    }

    
    return new ResponseEntity<>(trenerDTOS, HttpStatus.OK);
}

    //registracija novog trenera
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trener> createTrener(@RequestBody Trener t) throws Exception {
        
    	Trener trener = new Trener(t.getKorisnickoIme(), t.getLozinka(),
                t.getIme(),  t.getPrezime(),  t.getKontakt_telefon(), t.getEmail(),  t.getDatum_rodjenja(), t.getUloga());

        
    	Trener newTrener = trenerService.create(trener);

     
        return new ResponseEntity<>(newTrener, HttpStatus.CREATED);
    }
    
/*
    Metoda za brisanje postojećeg trenera
 */
@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> deleteTrener(@PathVariable Long id) {
    
    this.trenerService.delete(id);

 
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

}