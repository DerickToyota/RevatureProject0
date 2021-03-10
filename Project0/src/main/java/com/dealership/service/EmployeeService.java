package com.dealership.service;

import com.dealership.db.GenericDao;
import com.dealership.model.Employee;

public class EmployeeService {
    GenericDao<Employee, String> ej;

    public EmployeeService(GenericDao<Employee, String> ej){this.ej = ej;}

    private boolean doesUsernameExist(String username){
        return ej.doesIDExist(username);
    }

    public Employee findEmployeeByUsername(String username){
        return ej.getbyId(username);
    }
}
