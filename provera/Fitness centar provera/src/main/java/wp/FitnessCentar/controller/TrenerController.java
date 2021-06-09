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


import wp.FitnessCentar.model.Trener;
import wp.FitnessCentar.model.Trener;
import wp.FitnessCentar.model.dto.TrenerDTOReg;
import wp.FitnessCentar.model.dto.TrenerDTO;
import wp.FitnessCentar.model.dto.TrenerDTOPrijava;
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
    
    /*dobavljanje 1 trenera
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
    Metoda za dobavljanje svih trenera
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

/*
 * Registracija novog trenera
 */
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<TrenerDTOReg> createTrener(@RequestBody TrenerDTOReg trenerDTOReg) throws Exception {
	
Trener trener = new Trener(trenerDTOReg.getKorisnickoIme(), trenerDTOReg.getLozinka(),
		trenerDTOReg.getIme(),trenerDTOReg.getPrezime(), trenerDTOReg.getKontakt_telefon(),trenerDTOReg.getEmail(),trenerDTOReg.getDatum_rodjenja(),trenerDTOReg.getUloga());


Trener newTrener = trenerService.create(trener);


TrenerDTOReg newTrenerDTOReg = new TrenerDTOReg(newTrener.getId(), newTrener.getKorisnickoIme(),
  newTrener.getLozinka(), newTrener.getIme(), newTrener.getPrezime(),newTrener.getKontakt_telefon(),newTrener.getEmail(),newTrener.getDatum_rodjenja(),newTrener.getUloga());


return new ResponseEntity<>(newTrenerDTOReg, HttpStatus.CREATED);
}


//za registraciju trenera od strane admina
@PostMapping(
		value="/sacuvajTrenera",
		consumes=MediaType.APPLICATION_JSON_VALUE,
		produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trener> registrujtrenera(@RequestBody Trener t) throws Exception{
		Trener trener=new Trener(t.getId(),t.getKorisnickoIme(),t.getLozinka(),t.getIme(),t.getPrezime(),t.getKontakt_telefon(),t.getEmail(),t.getDatum_rodjenja(),t.getUloga());
		Trener noviTrener=trenerService.registracija(trener);
		return new ResponseEntity<>(noviTrener,HttpStatus.OK);
	}

@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> deleteTrener(@PathVariable Long id) {
    
    this.trenerService.delete(id);

 
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

/* Logovanje tj pronalazenje trenera u bazi
 */
	@PostMapping(
		value="/loginTrenera",
		consumes = MediaType.APPLICATION_JSON_VALUE,     
       produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trener> login(@RequestBody Trener trener) throws Exception{
		Trener t=this.trenerService.Find(trener.getKorisnickoIme(),trener.getLozinka());
		if(t!=null) {
			Trener povratna=new Trener(t.getId(),t.getKorisnickoIme(),t.getLozinka(),t.getIme(),t.getPrezime(),t.getKontakt_telefon(),t.getEmail(),t.getDatum_rodjenja(),t.getUloga());
			System.out.println(povratna.getEmail());
			return new ResponseEntity<>(povratna,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<?> prijava(@RequestBody TrenerDTOPrijava trenerDTOPrijava) {
		Trener trener;
		try {
			trener=this.trenerService.checkKorisnickoIme(trenerDTOPrijava);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		if(trener==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(!(this.trenerService.prijava(trenerDTOPrijava, trener))) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Trener>(trener, HttpStatus.OK);
	}
	@GetMapping("/profilTrenera/{id}")
	public String account(@PathVariable(name = "id") Long id,Model model) {
		Trener trener=this.trenerService.findOne(id);
		model.addAttribute("trener", trener);
		return "trenerNaslovna.html";
	}

}