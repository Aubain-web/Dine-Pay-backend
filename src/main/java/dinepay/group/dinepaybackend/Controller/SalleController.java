package dinepay.group.dinepaybackend.Controller;

import dinepay.group.dinepaybackend.Entity.SalleEntity;
import dinepay.group.dinepaybackend.Service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dinepay/salle")
public class SalleController {

    @Autowired
    private SalleService salleService;

    @PostMapping
    public ResponseEntity<SalleEntity> createSalle (@RequestBody SalleEntity salleEntity){
        SalleEntity createSalle = salleService.createSalle(salleEntity);
        return new ResponseEntity<>(createSalle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SalleEntity>> getAllSalles (){
        List<SalleEntity> salles = salleService.getAllSalles();
        return  ResponseEntity.ok(salles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalleEntity> getSalleById (@RequestBody Long id){
        SalleEntity salle = salleService.getSalleById(id);
        if(salle != null){
            return  ResponseEntity.ok(salle);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalleEntity> updateSalle (@PathVariable Long id,@RequestBody  SalleEntity salleEntity){
        SalleEntity updatedSalle = salleService.updateSalle(id, salleEntity);
        if(updatedSalle != null){
            return new ResponseEntity<>(updatedSalle, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        boolean salleDeleted = salleService.deleteSalle(id);
        if (salleDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
