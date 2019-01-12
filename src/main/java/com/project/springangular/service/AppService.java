package com.project.springangular.service;

import java.util.List;

import com.project.springangular.entity.Employee;

public interface AppService {

    Employee findById(long id);

    List<Employee> searchByName(String name);

    void saveEmployee(Employee emp);

    void updateEmployee(Employee emp);

    List<Employee> findAllEmployees();
}
