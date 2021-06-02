package wp.FitnessCentar.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import wp.FitnessCentar.model.Trening;
import wp.FitnessCentar.model.dto.TreningDTO;
import wp.FitnessCentar.service.TreningService;

@RestController
@RequestMapping(value = "/api/trening") 
public class TreningController {

    private final TreningService treningService; 

    // constructor-based dependency injection
    @Autowired
    public TreningController(TreningService treningService) {
        this.treningService = treningService;
    }
    
    
    /*
    Metoda za dobavljanje svih treninga
    -pregled treninga-
  -----------------------------------------
*/
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi() {
       
        List<Trening> treningList = this.treningService.findAll();

        
        List<TreningDTO> treningDTOS = new ArrayList<>();

        for (Trening trening : treningList) {
            
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                    trening.getOpis(), trening.getTip_treninga(), trening.getTrajanje());
            treningDTOS.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }

}