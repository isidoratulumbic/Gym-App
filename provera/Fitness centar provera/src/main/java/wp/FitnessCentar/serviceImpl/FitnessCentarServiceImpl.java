package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	/*@Override
	public FitnessCentar save(FitnessCentar f) {
		return this.fitnessCentarRepository.save(f);
		
	}*/

		
	}
