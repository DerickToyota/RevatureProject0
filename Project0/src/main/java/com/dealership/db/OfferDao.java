package com.dealership.db;

import com.dealership.config.ConnectionUtil;
import com.dealership.model.Offer;
import com.dealership.model.OfferStatus;

import java.sql.*;

public class OfferDao implements GenericDao<Offer, Integer>{

    private static OfferDao instance;

    private OfferDao(){}

    static OfferDao getInstance(){
        if (instance == null){
            instance = new OfferDao();
        }
        return instance;
    }


    @Override
    public int save(Offer offer) {
        try {
            String sql = "insert into project_zero.offer values ("+ offer.getId() + ", '" +
                    offer.getUsername() +    "', " + offer.getVin() + ", " + offer.getAmount() +", '"+ offer.getStatus().name()+ "')";

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
    public Offer getbyId(Integer id) {
            try {

                String sql = "select * from project_zero.offer where id =" + id + ";";
                Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
                ResultSet rs = st.executeQuery(sql);

                rs.next();

                 return new Offer(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                        OfferStatus.valueOf(rs.getString(5)));

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }


    /*  Credit for implementing the SQL call function to
    https://www.tutorialspoint.com/how-to-call-an-existing-function-in-a-database-using-jdbc-api
      */
    @Override
    public boolean remove(Integer id) {
        try {

            //String sql = "select deletes(cast("+id +" as INTEGER));";
//            String sql = "select delete3();";
//            System.out.println(sql);
//            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
//            int i = st.executeUpdate(sql);

            //Preparing a CallableStatement to call a function
            CallableStatement cstmt = ConnectionUtil.getInstance().getConnection().prepareCall("{? = call delete3()}");
            //Registering the out parameter of the function (return type)
            cstmt.registerOutParameter(1, Types.OTHER);
            cstmt.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Offer offer) {

        try {
            String sql = "update project_zero.offer set status = '"+offer.getStatus().toString()+"' where id ="+offer.getId()+";";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            int i = st.executeUpdate(sql);
            System.out.println("The number of updated rows were " + i);

            if(i == 1){
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean doesIDExist(Integer id) {
        return false;
    }

    @Override
    public void getAll() {
        try {

            String sql = "select * from project_zero.offer order by vin;";
            Statement st = ConnectionUtil.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                Offer o = new Offer(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
                        OfferStatus.valueOf(rs.getString(5)));
                System.out.println(o.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
