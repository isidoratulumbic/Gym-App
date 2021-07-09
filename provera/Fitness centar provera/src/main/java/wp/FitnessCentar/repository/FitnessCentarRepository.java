package wp.FitnessCentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import wp.FitnessCentar.model.FitnessCentar;

public interface FitnessCentarRepository extends JpaRepository<FitnessCentar, Long> {
    FitnessCentar findByNazivIgnoreCase(String naziv);
}


