package wp.FitnessCentar.service;

import java.util.List;

import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.dto.ClanDTOPrijava;

public interface ClanService {
	 Clan findOne(Long id);
	 
	 List<Clan> findAll();
	 
	 Clan create(Clan clan) throws Exception;

	  void delete(Long id);

	Clan Find(String korisnickoIme, String lozinka);
	
	boolean prijava(ClanDTOPrijava clanDTOPrijava, Clan clan);
	
	Clan checkKorisnickoIme(ClanDTOPrijava clanDTOPrijava);

}
