package ali.ashique.restcontrollers;

import ali.ashique.dto.EmployeeList;
import ali.ashique.model.Employee;
import ali.ashique.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Data
@RestController
@RequestMapping("v1/employees")
@AllArgsConstructor
public class EmployeeRestController {

    private EmployeeService employeeService;

    @GetMapping
    public EmployeeList findAll(){
        EmployeeList employeeList=new EmployeeList();
        employeeList.setEmployees(employeeService.findAll());
        return employeeList;
    }
    @GetMapping("/pages")
    public EmployeeList findAllPages(@RequestParam("page") int page,@RequestParam("size") int size){
        PageRequest of = PageRequest.of(page, size);
        List<Employee> content = employeeService.findAll(of).getContent();
        EmployeeList employeeList= new EmployeeList(content);
        return employeeList;
    }
    @GetMapping("/total-pages")
    public long totalRecords(@RequestParam("page") int page,@RequestParam("size") int size){
        PageRequest of = PageRequest.of(page, size);
        return employeeService.findAll(of).getTotalPages();

    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Employee employee){
            int years = employee.getHireDate().getYear()-employee.getDob().getYear();
        long between = ChronoUnit.YEARS.between(employee.getDob(), employee.getHireDate());

        if (between>=18){
            employeeService.save(employee);
        }else {
            return new ResponseEntity<String>("Employee must have 18 years of age",HttpStatus.OK);
        }
        return ResponseEntity.ok("1");
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Integer id){
        return employeeService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        employeeService.deleteById(id);
    }
}
