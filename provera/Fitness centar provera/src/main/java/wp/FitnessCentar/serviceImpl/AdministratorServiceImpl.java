package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
/*
//za dodavanje fc
public Administrator findByKorisnicko_ime(String korisnicko_ime) {
	Administrator a=this.administratorRepository.findByKorisnicko_ime(korisnicko_ime);
	return  a;
}*/

}