package com.project.springangular.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.project.springangular.entity.Employee;

@Repository
@SuppressWarnings("unchecked")
public class AppDaoImpl implements IAppDao {

    @Autowired
    private HibernateTemplate template;

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) template.find("from Employee");
    }

    @Override
    public Employee getEmployeeById(long id) {
        return (Employee) template.find("from Employee where id = ?", id).get(0);
    }

    @Override
    public List<Employee> searchEmployeeByName(String name) {
        return (List<Employee>) template.find("from Employee where lower(name) like ?", "%" + name.toLowerCase() + "%");
    }

    @Override
    public void save(Employee e) {
        template.persist(e);
    }

    @Override
    public void updateEmployee(Employee e) {
        template.update(e);
    }
}