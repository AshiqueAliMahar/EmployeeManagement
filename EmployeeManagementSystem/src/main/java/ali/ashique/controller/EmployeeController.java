package ali.ashique.controller;

import ali.ashique.dto.EmployeeList;
import ali.ashique.model.Employee;
import ali.ashique.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Controller
@RequestMapping({"/", ""})
@RequiredArgsConstructor
public class EmployeeController {
    @NonNull
    private RestTemplate restTemplate;
    @Value("${url}")
    private String url;
    @NonNull
    private EmployeeService employeeService;

    @GetMapping
    public String findAll(@RequestParam("page") Optional<Integer> page, Model model) {

        page = Optional.of(page.orElse(0));
        Page<Employee> employeePage = employeeService.findAll(PageRequest.of(page.get(), 10));

        int totalPages = employeePage.getTotalPages();

        if (totalPages > 0) {
            List<Long> pageNumbers = LongStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute(employeePage.getContent());
        model.addAttribute("currentPage", page.get());

        if (!model.containsAttribute("employee")) {
            Employee employee = Employee.builder().build();
            model.addAttribute(employee);
        }

        return "index";
        //        String path = url.concat("v1/employees");
//        EmployeeList employeeList = restTemplate.getForObject(URI.create(path), EmployeeList.class);
//        model.addAttribute(employeeList.getEmployees());
//
//        Employee employee = Employee.builder().build();
//        model.addAttribute(employee);
        //UriComponents build = UriComponentsBuilder.fromUriString(url).path("v1/employees/pages").queryParam("page", page.get()).queryParam("size", 2).build();
        //EmployeeList employeeList = restTemplate.getForObject(build.toUri(), EmployeeList.class);
        //build = UriComponentsBuilder
//                .fromUriString(url)
//                .path("v1/employees/total-pages")
//                .queryParam("page", page.get())
//                .queryParam("size", 2)
//                .build();
//       restTemplate.getForObject(build.toUri(), Long.class);
    }

    @PostMapping
    public String save(@ModelAttribute Employee employee, Model model) {

        long between = ChronoUnit.YEARS.between(employee.getDob(), employee.getHireDate());
        if (between >= 18) {
            employeeService.save(employee);
            employee = new Employee();
            model.addAttribute(employee);
            return "redirect:/?m=" + "Record saved Successfully";
        } else {
            model.addAttribute("msg", "Employee must have 18 years of age");
        }
        return findAll(Optional.of(Integer.valueOf(0)), model);
        //        String path = url.concat("v1/employees");
//
//        ResponseEntity<String> result = restTemplate.postForEntity(URI.create(path), employee, String.class);
        //EmployeeList employeeList = restTemplate.getForObject(URI.create(path), EmployeeList.class);
        //model.addAttribute(employeeList.getEmployees());
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        Employee employee = employeeService.findById(id);
        model.addAttribute(employee);
        return findAll(Optional.of(Integer.valueOf(0)), model);
        //        path = url.concat("v1/employees");
//        EmployeeList employeeList = restTemplate.getForObject(URI.create(path), EmployeeList.class);
//        model.addAttribute(employeeList.getEmployees());
//        return "index";
        // String path = url.concat("v1/employees/").concat(id + "");
        //Employee employee = restTemplate.getForObject(URI.create(path), Employee.class);
    }

    @GetMapping("delete/{id}")
    public String deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        //restTemplate.delete(url.concat("v1/employees/").concat(id + ""));
        return "redirect:/?m=" + "Record Deleted Successfully";
    }
}
