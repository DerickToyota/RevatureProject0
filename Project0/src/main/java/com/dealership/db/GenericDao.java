package com.dealership.db;

/**
 * A dao contract to determine functionality in the Project0Dao objects.
 * @param <T> The class used for this dao object.
 * @param <I> The primary key used by the class.
 */

public interface GenericDao <T, I>{

    //save an instance to the db
    int save(T t);

    //select an object by its primary key
    T getbyId(I id);

    //TODO: create own GymCollection to handle this
    //gather all objects in the db
    //GymCollection getAll();

    //delete an object from the db
    boolean remove (I id);

    //update an object in the db
    boolean update(T t);

    boolean doesIDExist(I id);

    void getAll();

    //TODO: when an offer is accepted, update all other offers tied to that cat to declined
    // update all recods in a table that correspond to the objects inside the GymCollection argument
    //int updateAll(GymCollection collection);

}
