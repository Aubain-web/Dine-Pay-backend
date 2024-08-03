package dinepay.group.dinepaybackend.Service;

import dinepay.group.dinepaybackend.Entity.SalleEntity;
import dinepay.group.dinepaybackend.Repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    public SalleEntity createSalle(SalleEntity salleEntity) {return salleRepository.save(salleEntity);}

    public List<SalleEntity> getAllSalles(){ return salleRepository.findAll();}

    public SalleEntity getSalleById(Long id){
        Optional<SalleEntity> salle = salleRepository.findById(id);
        return salle.orElse(null);
    }

    public SalleEntity updateSalle(Long id, SalleEntity salleEntity){
        Optional<SalleEntity> existeSalle = salleRepository.findById(id);
        if (existeSalle.isPresent()){
            SalleEntity salle = existeSalle.get();
            salle.setNumeroSalle(salleEntity.getNumeroSalle());
            salle.setNombreTable(salleEntity.getNombreTable());
            return salleRepository.save(salle);
        }else{
            return null;
        }
    }

    public boolean deleteSalle(Long id){
        Optional<SalleEntity> existeSalle = salleRepository.findById(id);
        if(existeSalle.isPresent()){
            salleRepository.delete(existeSalle.get());
            return true;
        }else{
            return false;
        }

    }
}
