package wp.FitnessCentar.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import wp.FitnessCentar.model.Ocena;
import wp.FitnessCentar.repository.OcenaRepository;



public class OcenaServiceImpl {


	@Autowired
	private OcenaRepository ocenaRepository;
	
	public Ocena save(Ocena o1) {
		return this.ocenaRepository.save(o1);
	}
}
