package dinepay.group.dinepaybackend.Controller;

import dinepay.group.dinepaybackend.Entity.ProduitEntity;
import dinepay.group.dinepaybackend.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dinepay/produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping
    public ResponseEntity<ProduitEntity> createProduit (ProduitEntity produitEntity){
        ProduitEntity createProduit = produitService.createProduit(produitEntity);
        return new ResponseEntity<>(createProduit, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProduitEntity>> getAllProduits(){
        List<ProduitEntity> produits = produitService.getAllProduit();
        return ResponseEntity.ok(produits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitEntity> getProduitById(@PathVariable long id) {
        ProduitEntity produit = produitService.getProduitById(id);
        if (produit != null) {
            return ResponseEntity.ok(produit);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProduitEntity> updateProduit(@PathVariable long id, @RequestBody ProduitEntity produitEntity) {
        ProduitEntity updatedProduit = produitService.upadateProduit(id, produitEntity);
        if (updatedProduit != null) {
            return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable long id) {
        boolean deleted = produitService.deleteProduit(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
