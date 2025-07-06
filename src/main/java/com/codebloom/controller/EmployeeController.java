package com.codebloom.controller;

import com.codebloom.entity.Employee;
import com.codebloom.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome CodeBloom";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_HR')")
    public Employee onboardNewEmployee(@RequestBody Employee employee){
        return  employeeService.createNewEmployee(employee);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_HR') or asAuthority('ROLE_MANAGER')")
    public List<Employee> getAll(){
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_EMPLOYEE')")
    public Employee getEmployeeById( @PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }
}
