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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.dto.ClanDTO;
import wp.FitnessCentar.model.dto.ClanDTOPrijava;
import wp.FitnessCentar.model.dto.ClanDTOReg;
import wp.FitnessCentar.service.ClanService;

@RestController
@RequestMapping(value = "/api/clan") 
public class ClanController {

    private final ClanService clanService; 

    // constructor-based dependency injection
    @Autowired
    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }
 
    /*dobavljanje 1 clana
     -----------------*/
     
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> getClan(@PathVariable("id") Long id) {
        
        Clan clan = this.clanService.findOne(id);

       
        ClanDTO clanDTO = new ClanDTO();
        clanDTO.setId(clan.getId());
        clanDTO.setkorisnickoIme(clan.getkorisnickoIme());
        clanDTO.setIme(clan.getIme());
        clanDTO.setPrezime(clan.getPrezime());
        clanDTO.setKontakt_telefon(clan.getKontakt_telefon());
        clanDTO.setDatum_rodjenja(clan.getDatum_rodjenja());
        clanDTO.setUloga(clan.getUloga());
        
        return new ResponseEntity<>(clanDTO, HttpStatus.OK);
        }
        
    /*
    Metoda za dobavljanje svih clanova
*/
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<ClanDTO>> getClanovi() {
   
    List<Clan> clanList = this.clanService.findAll();

    
    List<ClanDTO> clanDTOS = new ArrayList<>();

    for (Clan clan : clanList) {
        
        ClanDTO clanDTO = new ClanDTO(clan.getId(), clan.getkorisnickoIme(),
                clan.getIme(), clan.getPrezime(),clan.getKontakt_telefon(),clan.getDatum_rodjenja(),clan.getUloga());
        clanDTOS.add(clanDTO);
    }

    
    return new ResponseEntity<>(clanDTOS, HttpStatus.OK);
}

  /*
   * Registracija novog clana
   */
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<ClanDTOReg> createClan(@RequestBody ClanDTOReg clanDTOReg) throws Exception {
	
Clan clan = new Clan(clanDTOReg.getKorisnickoIme(), clanDTOReg.getLozinka(),
		clanDTOReg.getIme(),clanDTOReg.getPrezime(), clanDTOReg.getKontakt_telefon(),clanDTOReg.getEmail(),clanDTOReg.getDatum_rodjenja(),clanDTOReg.getUloga());


Clan newClan = clanService.create(clan);


ClanDTOReg newClanDTOReg = new ClanDTOReg(newClan.getId(), newClan.getkorisnickoIme(),
    newClan.getLozinka(), newClan.getIme(), newClan.getPrezime(),newClan.getKontakt_telefon(),newClan.getEmail(),newClan.getDatum_rodjenja(),newClan.getUloga());


return new ResponseEntity<>(newClanDTOReg, HttpStatus.CREATED);
}
    
/*
    Metoda za brisanje postojećeg clana
 */
@DeleteMapping(value = "/{id}")
public ResponseEntity<Void> deleteClan(@PathVariable Long id) {
    
    this.clanService.delete(id);

 
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@PostMapping(
		value="/login",
		consumes = MediaType.APPLICATION_JSON_VALUE,     // tip podataka koje metoda može da primi
        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Clan> login(@RequestBody Clan clan) throws Exception{
		Clan c=this.clanService.Find(clan.getkorisnickoIme(),clan.getLozinka());

		if(c!=null) {
			Clan povratna=new Clan(c.getId(),c.getkorisnickoIme(),c.getLozinka(),c.getIme(),c.getPrezime(),c.getKontakt_telefon(),c.getEmail(),c.getDatum_rodjenja(),c.getUloga());
			System.out.println(povratna.getEmail());
			return new ResponseEntity<>(povratna,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
/*
@PostMapping("/login")
public ResponseEntity<?> prijava(@RequestBody ClanDTOPrijava clanDTOPrijava) {
	Clan clan;
	try {
		clan=this.clanService.checkKorisnickoIme(clanDTOPrijava);
	} catch (Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	if(clan==null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	if(!(this.clanService.prijava(clanDTOPrijava, clan))) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<Clan>(clan, HttpStatus.OK);
}*/
/*Profil člana
 
 */
/*
@GetMapping("/profilClana/{id}")
public String account(@PathVariable(name = "id") Long id,Model model) {
	Clan clan=this.clanService.findOne(id);
	model.addAttribute("clan", clan);
	return "clanNaslovna.html";
}*/

/*Odrađeni treninzi*/
/*
@GetMapping("/account/{id}/odradjeni_treninzi")
	public String odradjeni_treninzi(@PathVariable(name = "id") Long id,Model model) {
		Clan clan=this.clanService.findOne(id);
		model.addAttribute("clan", clan);
		return "odradjeni_treninzi.html";
	}*/
}