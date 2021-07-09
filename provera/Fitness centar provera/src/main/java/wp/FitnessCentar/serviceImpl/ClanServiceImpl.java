package wp.FitnessCentar.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.Termin;
import wp.FitnessCentar.model.dto.ClanDTOPrijava;
import wp.FitnessCentar.repository.ClanRepository;
import wp.FitnessCentar.service.ClanService;
import wp.FitnessCentar.service.TerminService;

@Service
public class ClanServiceImpl implements ClanService {
	@Autowired
	private TerminService terminService;
	private final ClanRepository clanRepository;
	
	 // constructor-based dependency injection
    @Autowired
    public ClanServiceImpl(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }
    
  
    /*
    Dobavljanje clana po ID-iju.
    Metoda vraća pronađenog clana, ako postoji.
*/
@Override
public Clan findOne(Long id) {
    Clan clan = this.clanRepository.getOne(id);
    return clan;
}
/*
Prikaz svih clanova */

@Override
public List<Clan> findAll() {
List<Clan> clan = this.clanRepository.findAll();
return clan;
}


@Override
public Clan create(Clan clan) throws Exception {
    if (clan.getId() != null) {
        throw new Exception("ID must be null!");
    }
    Clan newClan = this.clanRepository.save(clan);
    return newClan;
}

/*
Brisanje clana.
*/
@Override
public void delete(Long id) {
this.clanRepository.deleteById(id);
}

@Override
	public Clan Find(String korisnickoIme,String lozinka) {
		Clan c=this.clanRepository.findBykorisnickoImeAndLozinka(korisnickoIme, lozinka);
		return c;
	}

public boolean prijava(ClanDTOPrijava clanDTOPrijava, Clan clan) {
	if (clan.getLozinka().equals(clanDTOPrijava.getLozinka())) {
		return true;
	}
	return false;
}

public Clan checkKorisnickoIme(ClanDTOPrijava clanDTOPrijava) {
	Clan clan = this.clanRepository.findByKorisnickoIme(clanDTOPrijava.getKorisnickoIme());
	if (clan == null)
		return null;
	return clan;
}




//cuvanje odredjenog clana
	public Clan save(Clan clan) {
		return this.clanRepository.save(clan);
	}

}