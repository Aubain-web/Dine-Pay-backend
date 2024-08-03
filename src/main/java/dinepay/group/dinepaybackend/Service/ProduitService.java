package dinepay.group.dinepaybackend.Service;

import dinepay.group.dinepaybackend.Entity.ProduitEntity;
import dinepay.group.dinepaybackend.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public ProduitEntity createProduit (ProduitEntity produitEntity){ return produitRepository.save(produitEntity);}

    public List<ProduitEntity> getAllProduit () {return produitRepository.findAll();}

    public ProduitEntity getProduitById (Long id) {
        Optional<ProduitEntity> produit = produitRepository.findById(id);
        return  produit.orElse(null);
    }

    public ProduitEntity upadateProduit (Long id, ProduitEntity produitEntity){
        Optional<ProduitEntity> existeProduit = produitRepository.findById(id);
        if(existeProduit.isPresent()){
            ProduitEntity produit = existeProduit.get();
            produit.setPrix(produitEntity.getPrix());
            produit.setProductname(produitEntity.getProductname());
            produit.setCategory(produitEntity.getCategory());
            produit.setStock(produitEntity.getStock());
            return produitRepository.save(produit);
        } else {
            return null;
        }
    };

    public boolean deleteProduit (Long id){
        Optional<ProduitEntity> existeProduit = produitRepository.findById(id);
        if(existeProduit.isPresent()){
            produitRepository.delete(existeProduit.get());
            return true;
        } else {
            return false;
        }
    }


}
