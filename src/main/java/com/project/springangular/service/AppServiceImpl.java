package com.project.springangular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springangular.dao.IAppDao;
import com.project.springangular.entity.Employee;

@Service
@Transactional
public class AppServiceImpl implements AppService {

    @Autowired
    private IAppDao dao;

    public void saveEmployee(Employee emp) {
        dao.save(emp);
    }

    public void updateEmployee(Employee emp) {
        dao.updateEmployee(emp);
    }

    public List<Employee> findAllEmployees() {
        return dao.getAllEmployees();
    }

    public Employee findById(long id) {
        return dao.getEmployeeById(id);
    }

    public List<Employee> searchByName(String name) {
        return dao.searchEmployeeByName(name);
    }
}