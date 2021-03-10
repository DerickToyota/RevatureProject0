package com.dealership.db;

import com.dealership.config.ConnectionUtil;
import com.dealership.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao implements GenericDao<Employee, String> {

    private static EmployeeDao instance;

    private EmployeeDao(){}

    static EmployeeDao getInstance(){
        if(instance == null){
            instance = new EmployeeDao();
        }
        return instance;
    }

    //Save Employees to the database was not part of mvp
    @Override
    public int save(Employee employee) {
        System.out.println("NOT IMPLEMENTED IN THIS VERSION OF APPLICATION");
        return 0;
    }

    //username == id
    @Override
    public Employee getbyId(String id) {
        if(doesIDExist(id)) {

            try {

                String sql = "select * from project_zero.employee where username = '" + id + "';";
                Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);
                String result = "";

                rs.next();

                return new Employee(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    //Not part of mvp
    @Override
    public boolean remove(String id) {
        return false;
    }

    //Not part of mvp
    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean doesIDExist(String id) {
        try{
            String sql = "select * from project_zero.employee where username = '" + id + "';";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs =  st.executeQuery(sql);

            String result = "";
            rs.next();
            result = rs.getString(1);
            return (result != null);
        }catch (SQLException e){
            //If it throws sql exception, means username is not in the database, and attempt counts as one fail login
            // e.printStackTrace();
            return false;
        }
    }


    @Override
    public void getAll() {

    }
}
