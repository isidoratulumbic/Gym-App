package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.repository.TreningRepository;
import wp.FitnessCentar.service.TreningService;



@Service
public class TreningServiceImpl implements TreningService {
	
	private final TreningRepository treningRepository;
	
	 // constructor-based dependency injection
    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository) {
        this.treningRepository = treningRepository;
    }
    
  /*
    Prikaz svih treninga*/

@Override
public List<Trening> findAll() {
    List<Trening> trening = this.treningRepository.findAll();
    return trening;
    }

@Override
public Trening create(Trening trening) throws Exception {
    if (trening.getId() != null) {
        throw new Exception("ID must be null!");
    }
    Trening newTrening = this.treningRepository.save(trening);
    return newTrening;
}
@Override
public Trening save(Trening t) {
	return this.treningRepository.save(t);
}
@Override
public List<Trening> orderNaziv(){
	return this.treningRepository.findAllByOrderByNaziv();
}
@Override
public List<Trening> orderTip(){
	return this.treningRepository.findAllByOrderByTipTreninga();
}
@Override
public List<Trening> orderOpis(){
	return this.treningRepository.findAllByOrderByOpis();
}
/*@Override
public List<Trening> orderCena(){
	return this.treningRepository.findAllByOrderByCena();
}
@Override
public List<Trening> orderVreme(){
	return this.treningRepository.findAllByOrderByVreme();
}*/
}
