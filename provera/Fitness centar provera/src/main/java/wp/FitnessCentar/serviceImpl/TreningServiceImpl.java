package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.repository.TreningRepository;
import wp.FitnessCentar.service.TreningService;



@Service
public class TreningServiceImpl implements TreningService {
	
	private final TreningRepository treningRepository;
	
	 // constructor-based dependency injection
    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository) {
        this.treningRepository = treningRepository;
    }
    
  /*
    Prikaz svih treninga*/

@Override
public List<Trening> findAll() {
    List<Trening> trening = this.treningRepository.findAll();
    return trening;
    }
}