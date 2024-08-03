package dinepay.group.dinepaybackend.Service;

import dinepay.group.dinepaybackend.Entity.EmployeeEntity;
import dinepay.group.dinepaybackend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity createEmployee (EmployeeEntity employeeEntity) {return employeeRepository.save(employeeEntity);}

    public List<EmployeeEntity> getAllEmployees() {return employeeRepository.findAll();}

    public EmployeeEntity getEmployeeById (Long id){
        Optional<EmployeeEntity>  employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public EmployeeEntity updateEmployee (Long id, EmployeeEntity employeeEntity){
        Optional<EmployeeEntity> existeEmployee = employeeRepository.findById(id);
        if(existeEmployee.isPresent()){
            EmployeeEntity employee = existeEmployee.get();
            employee.setNom(employeeEntity.getNom());
            employee.setPassword(employeeEntity.getPassword());
            return  employeeRepository.save(employee);

        } else {
            return null;
        }

    }

    public boolean deleteEmployee(Long id) {
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            employeeRepository.delete(existingEmployee.get());
            return true;
        } else {
            return false;
        }
    }
}
