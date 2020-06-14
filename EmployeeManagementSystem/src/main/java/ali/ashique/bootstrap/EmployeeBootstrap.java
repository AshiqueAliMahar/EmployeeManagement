package ali.ashique.bootstrap;

import ali.ashique.model.Employee;
import ali.ashique.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeBootstrap {
    private EmployeeService employeeService;
    @PostConstruct
    public void addEmployees() {
        List<Employee> employeeList = List.of(
                Employee
                        .builder()
                        .firstName("John")
                        .lastName("Jiralli")
                        .dob(LocalDate.of(1995, 12, 1))
                        .hireDate(LocalDate.of(2015, 2, 1))
                        .ssn("AAAAAAAAAA")
                        .build(),
                Employee
                        .builder()
                        .firstName("Kelly")
                        .lastName("Miranz")
                        .dob(LocalDate.of(1990, 2, 4))
                        .hireDate(LocalDate.of(2010, 3, 3))
                        .ssn("BBBBBBBBB")
                        .build(),
                Employee
                        .builder()
                        .firstName("Michael")
                        .lastName("Max")
                        .dob(LocalDate.of(1988, 3, 3))
                        .hireDate(LocalDate.of(2010, 2, 4))
                        .ssn("CCCCCCCCCC")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build(),
                Employee
                        .builder()
                        .firstName("Maria")
                        .lastName("Meh")
                        .dob(LocalDate.of(1985, 2, 4))
                        .hireDate(LocalDate.of(2015, 4, 2))
                        .ssn("DDDDDDDDDDD")
                        .build()
        );
        employeeService.saveAll(employeeList);
    }
}
