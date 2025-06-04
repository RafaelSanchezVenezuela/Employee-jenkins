package com.rafsanzd.EmployeeHP.EmployeeHP.services;


import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employee;
import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employees;
import com.rafsanzd.EmployeeHP.EmployeeHP.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository _employeeRepository = new EmployeeRepository();

    //private Employees employees = new Employees();
    //public Employee employeeInitial = new Employee("7","Mat","San","m@mail.com","Son");
    //public List<Employee> list = new ArrayList<>();

    @Override
    public Employees getAllEmployees(){
        Employees employeeList = new  Employees();
        employeeList.setEmployees(_employeeRepository.getAllEmployees().getEmployees());
        return  employeeList;
        /*
                list.add(employeeInitial);
        employees.setEmployees(list);
        return  employees;
         */
    }

    @Override
    public Employee saveEmployees(Employee employeeNew){
        return _employeeRepository.saveEmployees(employeeNew);
    }

}
