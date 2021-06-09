package wp.FitnessCentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import wp.FitnessCentar.model.Clan;

public interface ClanRepository extends JpaRepository<Clan, Long> {

	Clan findBykorisnickoIme(String korisnickoIme);
	
	Clan findBykorisnickoImeAndLozinka(String korisnickoIme,String lozinka);

    Clan findByKorisnickoIme(String korisnickoIme);
	 
	 
	
}


