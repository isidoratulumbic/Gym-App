package wp.FitnessCentar.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.repository.ClanRepository;
import wp.FitnessCentar.service.ClanService;

@Service
public class ClanServiceImpl implements ClanService {
	
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

/*Prijava na sistem
putem korisnickog imena 
*/
	public Clan prijava(String korisnickoIme) {
		//vracam clana sa tim korisnickoim imenom
		Clan c=this.clanRepository.findBykorisnickoIme(korisnickoIme);
		if(c==null) {
		
			return null;
		}
		else {
			return c;
		}
	}
	
	public Clan Find(String korisnickoIme,String lozinka) {
		Clan c=this.clanRepository.findBykorisnickoImeAndLozinka(korisnickoIme, lozinka);
		return c;
	}
}