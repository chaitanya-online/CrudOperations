package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Component
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceimpl employeeServiceimpl;

    @PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addEmployee(@Valid @RequestBody Employee employee) {

        return employeeServiceimpl.addEmployee(employee);

    }

    @PostMapping("/addEmployees")

    public String addEmployees(@Valid @RequestBody List<Employee> employee) {
        return employeeServiceimpl.addEmployees(employee);
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeServiceimpl.getAllEmployees();

    }

    @GetMapping("/getEmployById/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id) {
        return employeeServiceimpl.getEmployee(id);

    }

    @DeleteMapping("/deleteEmpById/{id}")
    public String deleteEmpById(@PathVariable int id) {
        employeeServiceimpl.deleteEmpById(id);
        return "Employee deleted " + id;
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee) {

        return employeeServiceimpl.updateEmployee(employee);

    }

    @PutMapping("/updateEmployeeBy/{id}")
    public String updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {

        employee.setId(id);
        return employeeServiceimpl.updateEmployeeById(employee);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Employee> findEmployeesWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Employee> employees = employeeServiceimpl.findEmployeesWithPagination(offset, pageSize);
        return employees;

    }

    @GetMapping("/getEmployeeByDomain/{domain}")
    public List<Employee> getEmployeeByDomain(@PathVariable String domain) {
        return employeeServiceimpl.getEmployeeByDomain(domain);
    }

    @GetMapping("/test")
    public String test(){
        return "Iam Working";
    }


}
