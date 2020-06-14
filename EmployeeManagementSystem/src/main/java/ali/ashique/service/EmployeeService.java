package ali.ashique.service;

import ali.ashique.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
public interface EmployeeService {
    public List<Employee> findAll();
    public Employee save(Employee employee);
    public void deleteById(long id);
    public Employee findById(long id);
    public List<Employee>  saveAll(List<Employee> employees);
    public Page<Employee> findAll(Pageable pageable);

    public long count();
}
