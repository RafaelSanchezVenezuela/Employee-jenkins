package com.rafsanzd.EmployeeHP.EmployeeHP;


import com.rafsanzd.EmployeeHP.EmployeeHP.controller.EmployeeController;
import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employee;
import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employees;
import com.rafsanzd.EmployeeHP.EmployeeHP.repository.EmployeeRepository;
import com.rafsanzd.EmployeeHP.EmployeeHP.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import static org.mockito.BDDMockito.given;


@SpringBootTest
class EmployeeHpApplicationTests {
	private final String fileDirectory = "C:\\MicroServices\\EmployeeHP\\src\\main\\resources\\Employees.json";
	@Mock
	private EmployeeRepository employeeRepo;
	//When using Mockito Use @InjectMocks to inject
	//Mocked beans to following class
	@InjectMocks
	private EmployeeServiceImpl EmployeeService;

	@Autowired
	private EmployeeController controller;

	public Employees employees = new Employees();
	public Employee employeeSaved = new Employee("3","Mai","Rod","r@mmail.com","Mam");
	public Employee employeeNew = new Employee("3","Mai","Rod","r@mmail.com","Mam");

	public EmployeeHpApplicationTests() {
		Employee employee1 = new Employee("1","Mat","San","m@mail.com","Son");
		Employee employee2 = new Employee("2","Raf","San","r@mail.com","Dad");
		employees.setEmployees(List.of(employee1,employee2));
	}

	@Test
	void getAllEmployees() {
		//given

		//When
		given(employeeRepo.getAllEmployees())
				.willReturn(employees);
		var  employeeList = EmployeeService.getAllEmployees();
		//Then
		//Make sure to import assertThat From org.assertj.core.api package
		assertThat(employeeList).isNotNull();
		assertThat(employeeList.getEmployees().size()).isEqualTo(2);
	}

	@Test
	void saveEmployee() {
		//given

		//When
		given(employeeRepo.saveEmployees(employeeNew))
				.willReturn(employeeSaved);
		var  employee = EmployeeService.saveEmployees(employeeNew);
		//Then
		//Make sure to import assertThat From org.assertj.core.api package
		assertThat(employee).isNotNull();
		assertThat(employee.getEmployee_id()).isEqualTo("3");
	}
}
