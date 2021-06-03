package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.FitnessCentar.model.Administrator;
import wp.FitnessCentar.model.Administrator;
import wp.FitnessCentar.repository.AdministratorRepository;
import wp.FitnessCentar.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	private final AdministratorRepository administratorRepository;
	
	 // constructor-based dependency injection
    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }
    /*
    Dobavljanje administratora po ID-iju.
    Metoda vraća pronađenog administratora, ako postoji.
*/
@Override
public Administrator findOne(Long id) {
	Administrator a = this.administratorRepository.getOne(id);
    return a;
}
/*
Prikaz svih administratora*/

@Override
public List<Administrator> findAll() {
List<Administrator> administrator = this.administratorRepository.findAll();
return administrator;
}

public Administrator save(Administrator a) {
	return this.administratorRepository.save(a);
}

@Override
public Administrator create(Administrator administrator) throws Exception {
    if (administrator.getId() != null) {
        throw new Exception("ID must be null!");
    }
    Administrator newAdministrator = this.administratorRepository.save(administrator);
    return newAdministrator;
}

/*
Brisanje administator.
*/
@Override
public void delete(Long id) {
this.administratorRepository.deleteById(id);
}

/*Prijava na sistem
putem korisnickog imena 
*/
	public Administrator prijava(String korisnickoIme) {
		//vracam administratora sa tim korisnickoim imenom
		Administrator a=this.administratorRepository.findBykorisnickoIme(korisnickoIme);
		if(a==null) {
		
			return null;
		}
		else {
			return a;
		}
	}
	
	public Administrator Find(String korisnickoIme,String lozinka) {
		Administrator a=this.administratorRepository.findBykorisnickoImeAndLozinka(korisnickoIme, lozinka);
		return a;
	}

//za dodavanje fc
public Administrator findByKorisnickoIme(String korisnickoIme) {
	Administrator a=this.administratorRepository.findByKorisnickoIme(korisnickoIme);
	return  a;
}

}