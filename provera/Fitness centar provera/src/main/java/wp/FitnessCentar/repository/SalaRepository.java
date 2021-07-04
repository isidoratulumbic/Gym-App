package wp.FitnessCentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import wp.FitnessCentar.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
	
}


