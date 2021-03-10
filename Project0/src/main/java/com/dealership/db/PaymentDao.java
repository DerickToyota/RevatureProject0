package com.dealership.db;

import com.dealership.config.ConnectionUtil;
import com.dealership.model.Car;
import com.dealership.model.Payment;
import com.dealership.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentDao implements GenericDao<Payment, Integer> {

    private static PaymentDao instance;

    private PaymentDao(){}

    static PaymentDao getInstance(){
        if (instance == null){ ;
            instance = new PaymentDao();
        }
        return instance;
    }

    @Override
    public int save(Payment p) {
        try {
            String sql = "insert into project_zero.payment values ('" +
                    p.getUsername() +    "', " + p.getVin() + ", " +
                    p.getStartPrice() +   ", " + p.getBalanceRemaining() + ", " +
                    p.getMonths() +       ", " + p.getNextPayment() + ")";

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
    public Payment getbyId(Integer id) {
        try {

            String sql = "select * from project_zero.payment where vin = " + id + ";";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            String result = "";

            rs.next();

            return new Payment(rs.getString(1), rs.getInt(2), rs.getInt(3),
                    rs.getDouble(4), rs.getInt(5), rs.getDouble(6));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    @Override
    public boolean update(Payment payment) {
        return false;
    }

    @Override
    public boolean doesIDExist(Integer id) {
        return false;
    }

    @Override
    public void getAll() {
        try {

            String sql = "select * from project_zero.payment where balance_remaining > 0;";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                Payment p = new Payment(rs.getString(1), rs.getInt(2), rs.getInt(3),
                        rs.getDouble(4), rs.getInt(5), rs.getDouble(6));
                System.out.println(p.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
