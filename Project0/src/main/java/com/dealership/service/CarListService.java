package com.dealership.service;

import com.dealership.db.GenericDao;
import com.dealership.model.CarList;

public class CarListService {
    GenericDao<CarList,String> cldao;

    public CarListService(GenericDao<CarList, String> cldao){
        this.cldao = cldao;
    }


    public void getOwnedCars(String username) {
        cldao.getbyId(username);
    }
}
