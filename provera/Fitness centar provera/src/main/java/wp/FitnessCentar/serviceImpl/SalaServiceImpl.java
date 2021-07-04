package wp.FitnessCentar.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wp.FitnessCentar.model.Sala;
import wp.FitnessCentar.repository.SalaRepository;
import wp.FitnessCentar.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService {
	
	private final SalaRepository salaRepository;
	
	 // constructor-based dependency injection
    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }
    
    @Override
    public Sala create(Sala sala) throws Exception {
        if (sala.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Sala newSala = this.salaRepository.save(sala);
        return newSala;
    }

	@Override
	public Sala save(Sala s) {
		return this.salaRepository.save(s);
		
	}

		
	  /*
    Dobavljanje FC po ID-iju.
    Metoda vraća pronađenog FC, ako postoji.
*/
@Override
public Sala findOne(Long id) {
    Sala sala = this.salaRepository.getOne(id);
    return sala;
}
/*
Prikaz svih FC */

@Override
public List<Sala> findAll() {
List<Sala> sala = this.salaRepository.findAll();
return sala;
}

/*
Brisanje FC.
*/
@Override
public void delete(Long id) {
this.salaRepository.deleteById(id);
}

	}
