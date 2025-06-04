package com.rafsanzd.EmployeeHP.EmployeeHP.controller;

import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employee;
import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employees;
import com.rafsanzd.EmployeeHP.EmployeeHP.services.EmployeeService;
import com.rafsanzd.EmployeeHP.EmployeeHP.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeService _employeeService ;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(_employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(_employeeService.saveEmployees(employee), HttpStatus.CREATED);
    }
}
