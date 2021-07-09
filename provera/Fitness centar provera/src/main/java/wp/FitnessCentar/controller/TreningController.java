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
import wp.FitnessCentar.model.dto.TreningDTOPretraga;
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
                    trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje(),trening.getSrednjaOcena());
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
		trening.setSrednjaOcena(o);
		this.treningService.save(trening);
		
		return new ResponseEntity<>(trening,HttpStatus.OK);
	}

    /*1 trening*/
    
    @GetMapping(
			value="/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TerminDTO>> prikaz(@PathVariable(name="id") Long id){
		Trening t=this.treningService.findOne(id);
		List<TerminDTO> p=new ArrayList<>();
		Set<Termin> termini=t.getTermini();
		if(termini.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		for (Termin t1 : termini) {
			TerminDTO tr=new TerminDTO();
			tr.setId(t.getId());
			tr.setBrojRezervacija(t1.getBrojRezervacija());
			tr.setNaziv(t1.getTrening().getNaziv());
			tr.setOpis(t1.getTrening().getOpis());
			tr.setTipTreninga(t1.getTrening().getTipTreninga());
			tr.setTrajanje(t1.getTrening().getTrajanje());
			tr.setSrednjaOcena(t1.getTrening().getSrednjaOcena());
			tr.setCena(t1.getCena());
			tr.setDan(t1.getDan());
			tr.setSalaOznaka(t1.getSala_treninga().getOznaka());
			tr.setVreme(t1.getVreme());
			tr.setFitnessCentar(t1.getSala_treninga().getFitness_centar().getNaziv());
			p.add(tr);
}
	
		
		return new ResponseEntity<>(p,HttpStatus.OK);
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

/*Pretraga*/
    
    @PostMapping(
			value="/pretraga",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TreningDTO>> pretraga(@RequestBody TreningDTOPretraga f)throws Exception{
			List<Termin> projekcije=this.terminService.findAll();
			List<TreningDTO> treninziDTO =new ArrayList<>();
			
			int znak=0; //znak da je bar neki parametar bo kad kod nekog filma
			boolean r=true;  //razlicit
			for (Termin tr : projekcije) {
				r=true;
				if(f.getNaziv()!="") {
					if(tr.getTrening().getNaziv().equalsIgnoreCase(f.getNaziv())) {
						znak=1;
						
					}else {
						r=false;
						
					}
				}if(f.getTipTreninga()!="") {
					if(tr.getTrening().getTipTreninga().equalsIgnoreCase(f.getTipTreninga())) {
						znak=1;
						
						
					}else {
						r=false;
						
						
					}
					
				}if(f.getOpis()!="") {
					if(tr.getTrening().getOpis().equalsIgnoreCase(f.getOpis())) {
						znak=1;
						
					}else {
						r=false;
						
					}
				}
					
				if(f.getCena()!=0) {
					if(tr.getCena()==f.getCena()) {
						znak=1;
						
					}else {
						r=false;
						
					}
				}if(f.getVreme()!="") {
					if(tr.getVreme().equalsIgnoreCase(f.getVreme())) {
						znak=1;
						
					}else {
						r=false;
						
					}
				}
				
				if(znak==1) {
					if(r==true) {
						TreningDTO treningDTO=new TreningDTO(tr.getTrening().getId(),tr.getTrening().getNaziv(),tr.getTrening().getOpis(),tr.getTrening().getTipTreninga(),tr.getTrening().getTrajanje(),tr.getTrening().getSrednjaOcena());
						
						/*if(!filmoviDTO.contains(filmDTO)) {
							filmoviDTO.add(filmDTO);
						}*/
						boolean postoji=false;
						for (TreningDTO trening : treninziDTO) {
							if(trening.getNaziv().equalsIgnoreCase(treningDTO.getNaziv())) {
								postoji=true;
							}
						}
						if(postoji==false) {
							treninziDTO.add(treningDTO);
						}
						
						
					}
				}
			}
			
			
			if(treninziDTO.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			}
			return new ResponseEntity<>(treninziDTO,HttpStatus.OK);
			
			
			
	}
    /*
    @GetMapping(
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
			consumes = MediaType.APPLICATION_JSON_VALUE,     // tip podataka koje metoda može da primi
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> rez(@RequestBody RezervacijaDTO r)throws Exception{
			Clan c=this.clanService.Find(r.getKorisnickoIme(), r.getLozinka());
			RezervacijaDTO rd=new RezervacijaDTO();
			rd.setId(c.getId().toString());
			if(c==null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				Long id=Long.parseLong(r.getId());
				Termin te=this.terminSrevice.findOne(id);
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
	}*/
    

}
