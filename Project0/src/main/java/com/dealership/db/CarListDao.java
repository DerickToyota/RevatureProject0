package com.dealership.db;

import com.dealership.config.ConnectionUtil;
import com.dealership.model.Car;
import com.dealership.model.CarList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarListDao implements GenericDao<CarList,String>{
    private static CarListDao instance;

    private CarListDao() {
    }

    static CarListDao getInstance() {
        if (instance == null){ ;
            instance = new CarListDao();
        }
        return instance;
    }


    @Override
    public int save(CarList carList) {
        return 0;
    }

    @Override
    public CarList getbyId(String id){
        System.out.println("Get All Method");
        try {

            String sql = "select * from project_zero.carlot where owner ='"+ id +"';";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                //would add car to list here
                Car c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                System.out.println(c.toString());

            }
            //return list
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public boolean update(CarList carList) {
        return false;
    }

    @Override
    public boolean doesIDExist(String id) {
        return false;
    }

    @Override
    public void getAll() {

    }
}

