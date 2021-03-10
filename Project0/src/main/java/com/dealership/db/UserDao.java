package com.dealership.db;

import com.dealership.config.ConnectionUtil;
import com.dealership.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//User is the object, String is the primary key
public class UserDao implements GenericDao<User, String> {

    private static UserDao instance;

    private UserDao(){}

    static UserDao getInstance(){
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }


    //TODO Finish refactoring the User u to match the Car app User

    @Override
    public int save(User u) {
        try {
            String sql = "insert into project_zero.user values ('" +
                    u.getUsername() +    "', '" + u.getPassword() + "', '" +
                    u.getFirstName() +   "', '" + u.getLastName() + "', '" +
                    u.getPhoneNumber() + "', '" + u.getEmail()    + "')";

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
    public User getbyId(String id) {
        if(doesIDExist(id)) {

            try {

                String sql = "select * from project_zero.user where username = '" + id + "';";
                Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);
                String result = "";

                rs.next();

                return new User(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }


    public boolean doesIDExist(String id) {
        try{
            String sql = "select * from project_zero.user where username = '" + id + "';";
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

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
