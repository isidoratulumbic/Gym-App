package wp.FitnessCentar.service;

import java.util.List;

import wp.FitnessCentar.model.Administrator;
import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.dto.AdministratorDTOPrijava;
import wp.FitnessCentar.model.dto.ClanDTOPrijava;


public interface AdministratorService {
	Administrator findOne(Long id);
	 
	 List<Administrator> findAll();
	 
	 Administrator create(Administrator administrator) throws Exception;

	 void delete(Long id);

	 Administrator Find(String korisnickoIme, String lozinka);
	  
	 Administrator findByKorisnickoIme(String a);
	 
	 boolean prijava(AdministratorDTOPrijava administratorDTOPrijava, Administrator administrator);
		
	Administrator checkKorisnickoIme(AdministratorDTOPrijava administratorDTOPrijava);

	

}
