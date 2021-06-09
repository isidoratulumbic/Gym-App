package wp.FitnessCentar.service;

import java.util.List;

import java.util.List;

import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.Trener;
import wp.FitnessCentar.model.dto.ClanDTOPrijava;
import wp.FitnessCentar.model.dto.TrenerDTOPrijava;

public interface TrenerService {
	 Trener findOne(Long id);
	 
	 List<Trener> findAll();
	 
	 Trener create(Trener trener) throws Exception;

	 void delete(Long id);
     
	 Trener Find(String korisnickoIme, String lozinka);

	 Trener registracija(Trener trener) throws Exception;
	   
	 boolean prijava(TrenerDTOPrijava trenerDTOPrijava, Trener trener);
		
	 Trener checkKorisnickoIme(TrenerDTOPrijava trenerDTOPrijava);
}

