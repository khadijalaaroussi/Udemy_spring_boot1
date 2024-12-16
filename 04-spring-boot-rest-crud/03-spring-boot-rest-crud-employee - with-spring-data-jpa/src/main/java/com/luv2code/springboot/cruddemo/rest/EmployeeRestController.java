package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired//and dirty: inject employee dao
    public EmployeeRestController(EmployeeService theemployeeService){
        employeeService=theemployeeService;
    }

    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findALL();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee= employeeService.findById(employeeId);

        if(theEmployee==null){
            throw new RuntimeException("employee id not found"+employeeId);
        }
       return theEmployee;
    }



    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

      theEmployee.setId(0);
      Employee dbEmployee=employeeService.save(theEmployee);
      return dbEmployee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeid}")
    public String deleteEmployee(@PathVariable int employeeid){

        Employee tempEmployee=employeeService.findById(employeeid);
        if(tempEmployee==null){
            throw new RuntimeException("Employee id not found"+
                    employeeid);
        }
        employeeService.deleteById(employeeid);
        return "deleted employee id "+employeeid ;
    }


}
