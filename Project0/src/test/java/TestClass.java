import com.dealership.db.DaoFactory;
import com.dealership.db.GenericDao;
import com.dealership.model.Car;
import com.dealership.service.LotService;
import com.enterprise.annotations.*;

import java.sql.SQLException;

@com.enterprise.annotations.TestClass
public class TestClass {

    public TestClass(){

    }

    LotService ls = new LotService(DaoFactory.daoFactory(Car.class));

    @TestMethod(expected = "test")
    public String testIfCarLotIsReachable(){
        try{
            Car c = ls.getCar(-1);
            return c.getColor();
        } catch (Exception e) {
            return null;
        }
    }



}
