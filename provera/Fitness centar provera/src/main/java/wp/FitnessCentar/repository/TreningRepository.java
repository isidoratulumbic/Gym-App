package wp.FitnessCentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wp.FitnessCentar.model.Trening;


public interface TreningRepository extends JpaRepository<Trening, Long> {
	
}


