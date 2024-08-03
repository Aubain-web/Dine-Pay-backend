package dinepay.group.dinepaybackend.Service;

import dinepay.group.dinepaybackend.Entity.TableEntity;
import dinepay.group.dinepaybackend.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    public TableEntity createTable (TableEntity tableEntity){
        return tableRepository.save(tableEntity);
    }

    public List<TableEntity> getAllTables(){
        return tableRepository.findAll();
    }

    public TableEntity getTableById (long id){
        Optional<TableEntity> table = tableRepository.findById(id);
        return table.orElse(null);
    }

    public TableEntity updateTable (long id, TableEntity tableEntity){
        Optional<TableEntity> existeTable = tableRepository.findById(id);
        if(existeTable.isPresent()){
            TableEntity table = existeTable.get();
            table.setNumeroTable(tableEntity.getNumeroTable());
            table.setNombrePlaces(tableEntity.getNombrePlaces());
            table.setPosX(tableEntity.getPosX());
            table.setPosY(tableEntity.getPosY());
            return tableRepository.save(table);
        }  else {
            return null;
        }

    }

    public boolean deleteTable(long id){
        Optional<TableEntity> existeTable = tableRepository.findById(id);
        if (existeTable.isPresent()) {
            tableRepository.delete(existeTable.get());
            return true;
        } else {
            return false;
        }
    }


    }


