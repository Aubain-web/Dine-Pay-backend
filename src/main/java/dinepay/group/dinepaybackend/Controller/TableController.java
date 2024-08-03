package dinepay.group.dinepaybackend.Controller;

import dinepay.group.dinepaybackend.Entity.TableEntity;
import dinepay.group.dinepaybackend.Service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dine-pay/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @PostMapping
    public ResponseEntity<TableEntity> createTable(@RequestBody TableEntity tableEntity){
        TableEntity createTable = tableService.createTable(tableEntity);
        return new ResponseEntity<>(createTable, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TableEntity>> getAllTables(){
        List<TableEntity> tables = tableService.getAllTables();
        return ResponseEntity.ok(tables);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableEntity> getTableById(@PathVariable long id) {
        TableEntity table = tableService.getTableById(id);
        if (table != null) {
            return ResponseEntity.ok(table);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableEntity> updateTable(@PathVariable long id, @RequestBody TableEntity tableEntity) {
        TableEntity updatedTable = tableService.updateTable(id, tableEntity);
        if (updatedTable != null) {
            return new ResponseEntity<>(updatedTable, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable long id) {
        boolean deleted = tableService.deleteTable(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
