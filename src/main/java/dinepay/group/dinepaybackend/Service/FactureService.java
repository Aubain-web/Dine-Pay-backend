package dinepay.group.dinepaybackend.Service;

import dinepay.group.dinepaybackend.Entity.FactureEntity;
import dinepay.group.dinepaybackend.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    public FactureEntity createFacture( FactureEntity factureEntity){return factureRepository.save(factureEntity);}


    public List<FactureEntity> getAllFacture(){return factureRepository.findAll();}

    public FactureEntity getFactureById(Long id){
        Optional<FactureEntity> existeFacture = factureRepository.findById(id);
        return existeFacture.orElse(null);
    }

    public FactureEntity updateFacture(Long id, FactureEntity factureEntity){
        Optional<FactureEntity> existeFacture = factureRepository.findById(id);
        if(existeFacture.isPresent()){
            FactureEntity facture = existeFacture.get();
            facture.setMontant(factureEntity.getMontant());
            return factureRepository.save(facture);
        }else{
            return null;
        }
    }

    public boolean deleteFacture(Long id){
        Optional<FactureEntity> existeFacture = factureRepository.findById(id);
        if(existeFacture.isPresent()){
            factureRepository.delete(existeFacture.get());
            return true;
        } else {
            return false;
        }
    }

    public List<FactureEntity> getAllFacturesOfOneTable(long id){
        return factureRepository.findFactureEntitiesByTableEntityId(id);
    }

    public Optional<FactureEntity> findFactureByCreationDate(Date date){
        return factureRepository.findByDateCreation(date);
    }

}
