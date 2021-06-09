package wp.FitnessCentar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import wp.FitnessCentar.model.Trening;


public interface TreningRepository extends JpaRepository<Trening, Long> {
	
	@Modifying
	@Query("update Trening set ocenjivanje= :ocenjivanje WHERE id = :treningId")
    void setOcenjivanje(@Param("treningId") Long id, @Param("ocenjivanje") double ocenjivanje);
	
	List<Trening> findAllByOrderByNaziv();
	
	List<Trening> findAllByOrderByTipTreninga();
	
	List<Trening> findAllByOrderByOpis();
	
	/*List<Trening> findAllByOrderByCena();
	
	List<Trening> findAllByOrderByVreme();*/
	
	
}


