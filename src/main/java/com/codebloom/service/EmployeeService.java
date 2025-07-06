package com.codebloom.service;

import com.codebloom.entity.Employee;
import com.codebloom.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createNewEmployee( Employee employee){
        return  employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById( Integer id){
        return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee Not Found with ID"+id));
    }
}
