package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import wp.FitnessCentar.model.Termin;
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
    
}