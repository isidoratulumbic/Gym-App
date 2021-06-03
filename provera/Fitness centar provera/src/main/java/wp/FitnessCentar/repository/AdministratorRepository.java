package wp.FitnessCentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wp.FitnessCentar.model.Administrator;
import wp.FitnessCentar.model.Clan;


public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
	
	Administrator findBykorisnickoIme(String korisnickoIme);
	
	Administrator findBykorisnickoImeAndLozinka(String korisnickoIme,String lozinka);
	
	/*Administrator findByKorisnickoIme(String korisnickoIme);*/
	
}


