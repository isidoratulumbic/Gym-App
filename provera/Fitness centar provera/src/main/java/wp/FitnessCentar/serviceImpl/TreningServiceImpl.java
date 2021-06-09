package wp.FitnessCentar.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import wp.FitnessCentar.model.Clan;
import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.model.dto.TreninziDTO;
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

/*@Override
public List<Trening> findAll() {
    List<Trening> trening = this.treningRepository.findAll();
    return trening;
    }*/

@Override
public Trening create(Trening trening) throws Exception {
    if (trening.getId() != null) {
        throw new Exception("ID must be null!");
    }
    Trening newTrening = this.treningRepository.save(trening);
    return newTrening;
}
/*@Override
public Trening save(Trening t) {
	return this.treningRepository.save(t);
}*/

/*@Override
public List<Trening> orderCena(){
	return this.treningRepository.findAllByOrderByCena();
}
@Override
public List<Trening> orderVreme(){
	return this.treningRepository.findAllByOrderByVreme();
}*/

public Trening findOne(Long id) {
	Trening trening=this.treningRepository.findById(id).get();
	return trening;
}

public List<Trening> findAll(){
	List<Trening> treninzi=this.treningRepository.findAll();
	return treninzi;
}

public Trening save(Trening trening) {
	return this.treningRepository.save(trening);
}

public TreninziDTO getData(){
	List<Trening> treninzi=findAll();
	List<String> tipoviTreninga=new ArrayList<String>();
	for(int i=0;i<treninzi.size();i++)
	{
		if(!tipoviTreninga.contains(treninzi.get(i).getTipTreninga())) {
			tipoviTreninga.add(treninzi.get(i).getTipTreninga());
		}
	}
	return new TreninziDTO(treninzi,tipoviTreninga);
}
public void setRating(Long id,double ocenjivanje) {
	this.treningRepository.setOcenjivanje(id, ocenjivanje);
}
}
