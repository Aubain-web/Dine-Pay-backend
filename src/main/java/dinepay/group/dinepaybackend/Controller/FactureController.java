package dinepay.group.dinepaybackend.Controller;

import dinepay.group.dinepaybackend.Entity.FactureEntity;
import dinepay.group.dinepaybackend.Entity.SalleEntity;
import dinepay.group.dinepaybackend.Service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dinepay/facture")
public class FactureController {


    @Autowired
    private FactureService factureService;

    @PostMapping
    public ResponseEntity<FactureEntity> createSalle (@RequestBody FactureEntity factureEntity){
        FactureEntity createFacture = factureService.createFacture(factureEntity);
        return new ResponseEntity<>(createFacture, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FactureEntity>> getAllFactures (){
        List<FactureEntity> factures = factureService.getAllFacture();
        return  ResponseEntity.ok(factures);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactureEntity> getFactureById (@PathVariable Long id){
        FactureEntity facture = factureService.getFactureById(id);
        if(facture != null){
            return  ResponseEntity.ok(facture);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FactureEntity> updateFacture (@PathVariable Long id, @RequestBody  FactureEntity factureEntity){
        FactureEntity updatedFacture = factureService.updateFacture(id, factureEntity);
        if(updatedFacture != null){
            return new ResponseEntity<>(updatedFacture, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        boolean factureDeleted = factureService.deleteFacture(id);
        if (factureDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allfacturesByTabelId/{id}")
    public ResponseEntity<List<FactureEntity>> getFacturesOneTable(@PathVariable Long id) {
        List<FactureEntity> allFactures = factureService.getAllFacturesOfOneTable(id);
        if (allFactures.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allFactures);
    }
}
