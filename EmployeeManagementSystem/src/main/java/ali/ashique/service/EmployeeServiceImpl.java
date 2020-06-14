package ali.ashique.service;

import ali.ashique.model.Employee;
import ali.ashique.repositories.EmployeeRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public long count() {
        return employeeRepo.count();
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Employee findById(long id) {

        return employeeRepo.findById(id).get();
    }

    @Override
    public List<Employee> saveAll(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }
}
