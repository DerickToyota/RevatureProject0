package com.dealership.db;

import com.dealership.config.ConnectionUtil;
import com.dealership.model.Car;
import com.dealership.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarDao implements GenericDao<Car, Integer> {

    private static CarDao instance;

    private CarDao() {
    }

    static CarDao getInstance() {
        if (instance == null){ ;
            instance = new CarDao();
        }
    return instance;
    }


    @Override
    public int save(Car car) {
        try {
            String sql = "insert into project_zero.carlot values ('" +
                    car.getVin() +    "', '" + car.getMake() + "', '" +
                    car.getModel() +   "', '" + car.getMiles() + "', '" +
                    car.getColor() + "', 'DEALERSHIP', '" + car.getPrice() + "')";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Car getbyId(Integer id) {
        try {

            String sql = "select * from project_zero.carlot where vin = '" + id + "';";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();

            return new Car(rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //TODO: Make this return a MyList of type car maybe
    //TODO:for now it just prints all to the console from the dao, better practice retun the list of objects
    //TODO: and let the service layer print to console?
    public void getAll() {
        try {

            String sql = "select * from project_zero.carlot where owner = 'DEALERSHIP';";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                    Car c = new Car(rs.getInt(1), rs.getString(2), rs.getString(3),
                            rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                    System.out.println(c.toString());

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean remove(Integer id) {
        try {

            String sql = "delete from project_zero.carlot where vin =" + id+ ";";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();

            int i = st.executeUpdate(sql);
            return (1 == i);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Car car) {
        try {
            String sql = "update project_zero.carlot set owner = '" +
                    car.getOwner() +    "' where vin = " + car.getVin() + ";";

            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean doesIDExist(Integer id) {
        try{
            String sql = "select * from project_zero.carlot where vin = " + id + ";";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs =  st.executeQuery(sql);
            int result = -1;

            if(!rs.next()){
                return false;
            }
//            rs.next();
//            System.out.println("rs.getInt(1): " +rs.getInt(1));
//            result = rs.getInt(1);
//                System.out.println(result);
//                if(id == result) {
//                    return true;
//                }
            return true;
        }catch (SQLException e){
            //If it throws sql exception, means username is not in the database, and attempt counts as one fail login
            e.printStackTrace();
            return true;
        }
    }
}
