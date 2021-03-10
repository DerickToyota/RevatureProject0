package com.dealership.service;

import com.dealership.db.GenericDao;
import com.dealership.model.Employee;
import com.dealership.model.User;


/**
 * for the user array, we should not care about the order they are added in,
 *      There should not be duplicates, if we reach the max size then it should
 *      be expandable, index should always point to the last valid object, and
 *      should never have gaps.
 *
 *
 // TODO: change password
 // TODO: delete users
 // TODO: update to members
 // TODO: update information
 // TODO: schedule workout times/sessions
 */
public class UserService {

    GenericDao<User, String> uj;

    public UserService(GenericDao<User, String> uj){
        this.uj = uj;
    }

    private static User[] users = new User[5];
    // TODO: potential risk of overriting users if index is not incremented and decremented carefully
    private static int currentUserIndex = -1;

    private static Employee[] employees = new Employee[5];
    private static int currentEmployeeIndex = -1;

    Employee e = new Employee("der","der","der","der","der","der");


    public boolean doesUsernameExist(String username){
        return uj.doesIDExist(username);
    }

    /*
            If given a valid user (one in the array)
                It will find the correct User
            If given a non valid user (one not in the array)
                it will return null
            If there are constraints (below the min char count,
                over the max char count, null, etc.) on the username,
                this method should reflect that and
                throw a Runtime exception if the constraints are
                violated.


     */
    public User findUserByUsername(String username){
        return uj.getbyId(username);

        // O(n) time complexity O(1) space complexity
//        if(currentUserIndex > -1) {
//            for (int i = 0; i <= currentUserIndex; i++) {
//                if (users[i].getUsername().equals(username)) {
//                    return users[i];
//                }
//            }
//        }
//        return null;


    }


    // TODO: Ensure duplicates do not exist, while minimizing calls to doesUsernameExist method.

    public boolean makeUser(String username, String password, String firstName, String lastName, String phoneNumber, String email){

        if(!doesUsernameExist(username)){
            if(1 == uj.save(new User(username, password, firstName, lastName, phoneNumber, email))){
                return true;
            }
        }
        return false;
//        if(!doesUsernameExist(username)){
//            if((currentUserIndex + 1) < users.length){
//                if(users[currentUserIndex+1] == null){
//                    users[++currentUserIndex] = new User(username, password, firstName, lastName, phoneNumber, email);
//                    System.out.println("Ready to insert user " + username+ " reginto the db at this point");
//                    uj.save(new User(username, password, firstName, lastName, phoneNumber, email));
//                    return true;
//                }
//            }
//        } else {
//            System.out.println("user already exists");
//        }
//        return false;
    }
/*
    public boolean makeCustomer(String username, String password, String phoneNumber, String email){
        if(!doesUsernameExist(username)){
            if((currentCustomerIndex + 1) < customers.length){
                if(customers[currentCustomerIndex +1] == null){
                    customers[++currentCustomerIndex] = new Customer(0, "firstname", "lastname", email, username, password);
                    return true;
                }
            }
        } else {
            System.out.println("customer account already exists");
        }
        return false;
    }
*/
    

    public Employee findEmployeeByUsername(String username) {
        System.out.println("find Employee by Username Not implemented YET");
        System.out.println("Queries the database to see if the username and password match");
     // return null;
        return new Employee("der","der","der","der","der","der");
    }
}