package com.rafsanzd.EmployeeHP.EmployeeHP.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employee;
import com.rafsanzd.EmployeeHP.EmployeeHP.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository  {
    //private final String fileDirectory = "C:\\MicroServices\\EmployeeHP\\src\\main\\resources\\Employees.json";
    private final String fileDirectory = "/app/data/Employees.json";

    public Employees getAllEmployees(){
        ObjectMapper objectMapper = new ObjectMapper();
        Employees employeeList = new  Employees();
        try {
            // Obtener el archivo JSON (ejemplo, desde el directorio de recursos)
            File file = new File(fileDirectory);  // Reemplazar con la ruta correcta
            // Analizar el JSON y mapearlo a un objeto Java
            employeeList = objectMapper.readValue(file, Employees.class);
            // Usar el objeto yourObject para acceder a los datos del JSON

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  employeeList;
    }

    public Employee saveEmployees(Employee employeeNew){
        ObjectMapper objectMapper = new ObjectMapper();
        Employees employeeList = new  Employees();

        try {
            File file = new File(fileDirectory);  // Reemplazar con la ruta correcta
            employeeList = objectMapper.readValue(file, Employees.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Employee> list = new ArrayList<>();
        list = employeeList.getEmployees();
        list.add(employeeNew);
        employeeList.setEmployees(list);

        Gson gson = new Gson();
        // Convertir el objeto a JSON
        String json = gson.toJson(employeeList);
        String updatedJson = json.replace("Employees", "employees");
        try (FileWriter writer = new FileWriter(fileDirectory)) {
            writer.write(updatedJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  employeeNew;
    }

}
