package com.project.springangular.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.springangular.entity.Employee;
import com.project.springangular.service.AppService;

@RestController
public class AppController {

    private static final Logger log = Logger.getLogger(AppController.class);

    @Autowired
    private AppService service;

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        log.info("Saving employee " + employee.getName());

        service.saveEmployee(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getByName(@PathVariable("name") String name) {
        log.info("Get employee whose name is " + name);
        List<Employee> employees = service.searchByName(name);
        if (employees.isEmpty()) {
            log.info("Employee with name " + name + " not found");
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getById(@PathVariable("id") long id) {
        log.info("Fetching employee with id " + id);
        Employee employee = service.findById(id);
        if (employee == null) {
            log.info("Employee with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee emp) {
        Employee present = service.findById(id);

        if (present == null) {
            log.info("Employee not found for id " + id);
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        present.setName(emp.getName()).setAddress(emp.getAddress()).setEmail(emp.getEmail());

        service.updateEmployee(present);
        return new ResponseEntity<Employee>(present, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = service.findAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

}