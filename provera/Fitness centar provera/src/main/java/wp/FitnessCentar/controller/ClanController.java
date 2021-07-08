package wp.FitnessCentar.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import wp.FitnessCentar.model.Ocena;
import wp.FitnessCentar.model.Termin;
import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.model.dto.ClanDTO;
import wp.FitnessCentar.model.dto.ClanDTOPrijava;
import wp.FitnessCentar.model.dto.ClanDTOReg;
import wp.FitnessCentar.model.dto.TerminDTO;
import wp.FitnessCentar.model.dto.TreningDTO;
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
@GetMapping(
		value="/clan-rezervacije/{id}",
		produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TerminDTO>> rezervisaniTreninzi(@PathVariable(name="id")Long id){
	 Clan c=this.clanService.findOne(id);
	 Set<Termin> rezervacije=c.getRezervisani_treninzi();
	 List<TerminDTO> povratna=new ArrayList<>();
	for (Termin t : rezervacije) {
		TerminDTO tr=new TerminDTO();
		tr.setId(t.getId());
		tr.setNaziv(t.getNaziv());
		tr.setTrajanje(t.getTrajanje());
		tr.setTipTreninga(t.getTipTreninga());
		tr.setOpis(t.getOpis());
		tr.setBrojRezervacija(t.getBrojRezervacija());
		tr.setCena(t.getCena());
		tr.setDan(t.getDan());
		tr.setVreme(t.getVreme());
	//	tr.setSalaOznaka(t.getSala().getOznaka());
		tr.setClanID(c.getId());
		povratna.add(tr);
	}
	return new ResponseEntity<>(povratna,HttpStatus.OK);
}*/

/*Odradjeni treninzi*/
@GetMapping(
		value="/clan-odradjeniTreninzi/{id}",
		produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TreningDTO>> odradjeniTreninzi(@PathVariable(name="id") Long id){
		Clan c=this.clanService.findOne(id);
		Set<Trening> treninzi=c.getOdradjeni_treninzi();
		List<TreningDTO> treninziDTO=new ArrayList<>();
		
		for (Trening f : treninzi) {
			TreningDTO fd=new TreningDTO();
			fd.setId(f.getId());
			fd.setNaziv(f.getNaziv());
			fd.setTipTreninga(f.getTipTreninga());
			fd.setOpis(f.getOpis());
			fd.setTrajanje(f.getTrajanje());
			fd.setSrednjaOcena(f.getSrednjaOcena());
			treninziDTO.add(fd);
		}
		
		return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
}
/*Ocenjeni treninzi*/
@GetMapping(
		value="/clan-ocenjeniTreninzi/{id}",
		produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TreningDTO>> ocenjeniTreninzi(@PathVariable(name="id") Long id){
		Clan c=this.clanService.findOne(id);
		Set<Ocena> treninzi=c.getOcene();
		List<TreningDTO> treninziDTO=new ArrayList<>();
		
		for (Ocena f : treninzi) {
			TreningDTO fd=new TreningDTO();
			fd.setId(f.getTrening().getId());
			fd.setNaziv(f.getTrening().getNaziv());
			fd.setTipTreninga(f.getTrening().getTipTreninga());
			fd.setOpis(f.getTrening().getOpis());
			fd.setTrajanje(f.getTrening().getTrajanje());
			
			
			fd.setSrednjaOcena(f.getOcena());
					
			
			//fd.setSrednjaOcena(f.getSrednja_ocena());
			treninziDTO.add(fd);
		}
		
		return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
}


@GetMapping(
		value="/clan-neocenjeniTreninzi/{id}",
		produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<TreningDTO>> neocenjeniTreninzi(@PathVariable(name="id") Long id){
		Clan c=this.clanService.findOne(id);
		Set<Trening> odradjeni=c.getOdradjeni_treninzi();
		Set<Ocena> ocene=c.getOcene();
		Set<Trening> ocenjeni=new HashSet<>();
		Trening trening=new Trening();
		for(Ocena o:ocene) {  //pravim listu ocenjenih filmova
			trening=o.getTrening();
			ocenjeni.add(trening);
		}
		List<TreningDTO> neocenjeni=new ArrayList<>();
		for(Trening t: odradjeni) {
			if(!ocenjeni.contains(t)) {
				TreningDTO td=new TreningDTO();
				td.setId(t.getId());
				td.setNaziv(t.getNaziv());
				td.setTipTreninga(t.getTipTreninga());
				td.setOpis(t.getOpis());
				td.setTrajanje(t.getTrajanje());
				td.setSrednjaOcena(t.getSrednjaOcena());
				td.setClanID(c.getId());
				neocenjeni.add(td);
			}
		}
		
		return new ResponseEntity<>(neocenjeni,HttpStatus.OK);
	
}

}