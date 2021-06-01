package wp.FitnessCentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import wp.FitnessCentar.model.Administrator;


public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
	
}


