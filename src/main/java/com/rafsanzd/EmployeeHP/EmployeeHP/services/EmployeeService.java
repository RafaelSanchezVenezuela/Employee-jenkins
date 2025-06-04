package com.rafsanzd.EmployeeHP.EmployeeHP.services;

import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employee;
import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employees;

public interface EmployeeService {
    public Employees getAllEmployees();

    Employee saveEmployees(Employee employeeNew);
}
