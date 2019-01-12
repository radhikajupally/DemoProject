package com.project.springangular.dao;

import java.util.List;

import com.project.springangular.entity.Employee;

public interface IAppDao {

    void save(Employee e);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    List<Employee> searchEmployeeByName(String name);

    void updateEmployee(Employee e);

}
