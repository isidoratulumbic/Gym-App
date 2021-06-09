package wp.FitnessCentar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


import wp.FitnessCentar.model.Termin;

public interface TerminRepository extends JpaRepository<Termin,Long> {
	
	
	List<Termin> findAllByOrderByCena();


}
