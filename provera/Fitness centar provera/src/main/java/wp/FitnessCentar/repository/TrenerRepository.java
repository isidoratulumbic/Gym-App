package wp.FitnessCentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.Trener;

public interface TrenerRepository extends JpaRepository<Trener, Long> {
	
	Trener findBykorisnickoIme(String korisnickoIme);
	
	Trener findBykorisnickoImeAndLozinka(String korisnickoIme,String lozinka);
	
}