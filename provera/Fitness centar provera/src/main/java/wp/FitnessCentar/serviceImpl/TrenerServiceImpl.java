package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.FitnessCentar.model.Trener;
import wp.FitnessCentar.model.Trener;
import wp.FitnessCentar.repository.TrenerRepository;
import wp.FitnessCentar.service.TrenerService;

@Service
public class TrenerServiceImpl implements TrenerService {
	
	private final TrenerRepository trenerRepository;
	
	 // constructor-based dependency injection
    @Autowired
    public TrenerServiceImpl(TrenerRepository trenerRepository) {
        this.trenerRepository = trenerRepository;
    }
    /*
    Dobavljanje trenera po ID-iju.
    Metoda vraća pronađenog trenera, ako postoji.
*/
@Override
public Trener findOne(Long id) {
	Trener trener = this.trenerRepository.getOne(id);
    return trener;
}
/*
Prikaz svih trenera */

@Override
public List<Trener> findAll() {
List<Trener> trener = this.trenerRepository.findAll();
return trener;
}


@Override
public Trener create(Trener trener) throws Exception {
    if (trener.getId() != null) {
        throw new Exception("ID must be null!");
    }
    Trener newTrener = this.trenerRepository.save(trener);
    return newTrener;
}

/*
Brisanje trenera.
*/
@Override
public void delete(Long id) {
this.trenerRepository.deleteById(id);
}
/*Prijava na sistem
putem korisnickog imena 
*/
	public Trener prijava(String korisnickoIme) {
		//vracam trenera sa tim korisnickoim imenom
		Trener t=this.trenerRepository.findBykorisnickoIme(korisnickoIme);
		if(t==null) {
		
			return null;
		}
		else {
			return t;
		}
	}
	
	public Trener Find(String korisnickoIme,String lozinka) {
		Trener t=this.trenerRepository.findBykorisnickoImeAndLozinka(korisnickoIme, lozinka);
		return t;
	}
}