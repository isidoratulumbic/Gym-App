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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.Termin;
import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.model.dto.RezervacijaDTO;
import wp.FitnessCentar.model.dto.TerminDTO;
import wp.FitnessCentar.model.dto.TreningDTO;
import wp.FitnessCentar.model.dto.TreninziDTO;
import wp.FitnessCentar.service.ClanService;
import wp.FitnessCentar.service.TerminService;
import wp.FitnessCentar.service.TreningService;

@RestController
@RequestMapping(value = "/api/trening") 
public class TreningController {

    private final TreningService treningService; 
    @Autowired
	private TerminService terminSrevice;
	@Autowired
	private ClanService clanService;

    // constructor-based dependency injection
    @Autowired
    public TreningController(TreningService treningService) {
        this.treningService = treningService;
    }
    @Autowired
	private TerminService terminService;
    
    /*
    Metoda za dobavljanje svih treninga
    -pregled treninga-
  -----------------------------------------
*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi() {
       
        List<Trening> treningList = this.treningService.findAll();

        
        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Trening trening : treningList) {
            
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                    trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje(),trening.getSrednja_ocena());
            treningDTOS.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }
    
    /*Dodavanje treninga
     * 
     */
    @PostMapping(
			value="/dodavanjeTreninga",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Trening> dodaj(@RequestBody TreningDTO t)throws Exception{
		Trening trening=new Trening();
		trening.setNaziv(t.getNaziv());
		trening.setOpis(t.getOpis());
		trening.setTipTreninga(t.getTipTreninga());
		trening.setTrajanje(t.getTrajanje());
		Double o=Double.parseDouble("0");
		trening.setSrednja_ocena(o);
		this.treningService.save(trening);
		
		return new ResponseEntity<>(trening,HttpStatus.OK);
	}

    
    /*Sortiranje treninga po ceni
     * 
     */
   /* @GetMapping(
			value="/sortCena",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TreningDTO>> sortCena(){
		List<Trening> treninzi=this.treningService.orderCena();
	
		
		List<TreningDTO> treninziDTO=new ArrayList<>();
		
		for(Trening trening:treninzi) {
			TreningDTO treningDTO=new TreningDTO(trening.getId(),trening.getNaziv(),trening.getOpis(),trening.getTipTreninga(),trening.getTrajanje(),trening.getSrednja_ocena());
			treninziDTO.add(treningDTO);
		}
		return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
	}*/
    
  /*  @GetMapping(
			value="/rezervisi/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TerminDTO> rezervisi(@PathVariable(name="id")Long id){
			Termin t=this.terminSrevice.findOne(id);
			TerminDTO td=new TerminDTO();
			td.setId(t.getId());
			
			return new ResponseEntity<>(td,HttpStatus.OK);
	}
	@PostMapping(
			value="/rezervacija",
			consumes = MediaType.APPLICATION_JSON_VALUE,     
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> rez(@RequestBody RezervacijaDTO r)throws Exception{
			Clan c=this.clanService.Find(r.getKorisnickoIme(), r.getLozinka());
			RezervacijaDTO rd=new RezervacijaDTO();
			rd.setId(c.getId().toString());
			if(c==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				Long id=Long.parseLong(r.getId());
				Termin te=this.terminService.findOne(id);
				if(te==null) {
				//	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
				Set<Termin> rezervisani=c.getRezervisani_treninzi();
				//uslov da bi mogao da rezervise
				if(te.getSala_treninga().getKapacitet()>te.getBrojRezervacija()) {
					te.setBrojRezervacija(te.getBrojRezervacija()+1);
					rezervisani.add(te);

					this.clanService.save(c);
				}else {
					//nema dovoljno mesta
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
			
				return new ResponseEntity<>(rd,HttpStatus.OK);
			}
	}

    
    @GetMapping("/treninzi")
	public String treninzi(Model model) {
		TreninziDTO treninziDTO=this.treningService.getData();
		model.addAttribute("treninziDTO", treninziDTO);
		return "treninzi.html";
	}
	
	@GetMapping("/trening/{id}")
	public String getTrening(@PathVariable(name = "id") Long id,Model model){
		Trening trening=this.treningService.findOne(id);
		model.addAttribute("trening", trening);
		return "trening.html";
	}*/
}