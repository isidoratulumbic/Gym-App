package wp.FitnessCentar.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.FitnessCentar.model.Termin;
import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.model.dto.TerminDTO;
import wp.FitnessCentar.repository.TerminRepository;
import wp.FitnessCentar.service.TerminService;


@Service
public class TerminServiceImpl implements TerminService {
	
	private final TerminRepository terminRepository;
	
	 // constructor-based dependency injection
    @Autowired
    public TerminServiceImpl(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }
    
    @Override
    public List<Termin> findAll(){
		List<Termin> termini=this.terminRepository.findAll();
		return termini;
	}
    
    @Override
    public List<Termin> orderCena(){
    	return this.terminRepository.findAllByOrderByCena();
    }
	
	public Termin findOne(Long id) {
        Termin termini= this.terminRepository.getOne(id);
        return termini;
    }
	
	public List<Termin> findByTrening(Trening t){
		List<Termin> termini=this.terminRepository.findAllByTrening(t);
		return termini;
	}
	
	public Termin save(Termin t) {
		Termin te=this.terminRepository.save(t);
		return te;
	}
	/*pretraga po Nazivu*/
	@Override
	public List<TerminDTO>findByName(String naziv){
		List<Termin> termini=this.terminRepository.findAllByTreningNazivContaining(naziv);
		List<TerminDTO> terminiDTO = new ArrayList<>();
		for(Termin termin : termini) {
			TerminDTO terDTO =new TerminDTO(termin.getId(),termin.getTrening().getNaziv(),termin.getTrening().getOpis(),termin.getTrening().getTipTreninga(),termin.getTrening().getTrajanje(),termin.getDan(),termin.getVreme(),termin.getCena(),termin.getBrojRezervacija());
					terminiDTO.add(terDTO);
		}
		return terminiDTO;
		
		}
	}
