package wp.FitnessCentar.service;

import java.util.List;

import wp.FitnessCentar.model.Administrator;


public interface AdministratorService {
	Administrator findOne(Long id);
	 
	 List<Administrator> findAll();
	 
	 Administrator create(Administrator administrator) throws Exception;

	  void delete(Long id);

	/*Administrator findByKorisnickoIme(String a);*/
	

}
