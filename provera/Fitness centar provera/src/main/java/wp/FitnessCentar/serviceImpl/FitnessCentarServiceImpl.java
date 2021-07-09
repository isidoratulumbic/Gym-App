package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.FitnessCentar;
import wp.FitnessCentar.repository.FitnessCentarRepository;
import wp.FitnessCentar.service.FitnessCentarService;


@Service
public class FitnessCentarServiceImpl implements FitnessCentarService {
	
	private final FitnessCentarRepository fitnessCentarRepository;
	
	 // constructor-based dependency injection
    @Autowired
    public FitnessCentarServiceImpl(FitnessCentarRepository fitnessCentarRepository) {
        this.fitnessCentarRepository = fitnessCentarRepository;
    }
    
    @Override
    public FitnessCentar create(FitnessCentar fitnessCentar) throws Exception {
        if (fitnessCentar.getId() != null) {
            throw new Exception("ID must be null!");
        }
        FitnessCentar newFitnessCentar = this.fitnessCentarRepository.save(fitnessCentar);
        return newFitnessCentar;
    }

	@Override
	public FitnessCentar save(FitnessCentar fc) {
		return this.fitnessCentarRepository.save(fc);
		
	}

	
	  /*
    Dobavljanje FC po ID-iju.
    Metoda vraća pronađenog FC, ako postoji.
*/
@Override
public FitnessCentar findOne(Long id) {
    FitnessCentar fitnessCentar = this.fitnessCentarRepository.getOne(id);
    return fitnessCentar;
}
/*
Prikaz svih FC */

@Override
public List<FitnessCentar> findAll() {
List<FitnessCentar> fitnessCentar = this.fitnessCentarRepository.findAll();
return fitnessCentar;
}

/*
Brisanje FC.
*/
@Override
public void delete(Long id) {
this.fitnessCentarRepository.deleteById(id);
}

@Override
public void saveFitnessCentar(FitnessCentar fc) {
	 this.fitnessCentarRepository.save(fc);
	
}
public FitnessCentar findNaziv(String naziv) {
	FitnessCentar fitnessCentar=this.fitnessCentarRepository.findByNazivIgnoreCase(naziv);
	return fitnessCentar;
}
}

	
