package com.dealership.service;

import com.dealership.model.Customer;
import com.dealership.model.Employee;


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


    private static Customer[] customers = new Customer[5];
    // TODO: potential risk of overriting users if index is not incremented and decremented carefully
    private static int currentCustomerIndex = -1;

    private static Employee[] employees = new Employee[5];
    private static int currentEmployeeIndex = -1;




    public boolean doesUsernameExist(String username){
        // O(n) time complexity O(1) space complexity
        return findCustomerByUsername(username) != null;
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
    public Customer findCustomerByUsername(String username){
        // O(n) time complexity O(1) space complexity
        if(currentCustomerIndex > -1) {
            for (int i = 0; i <= currentCustomerIndex; i++) {
                if (customers[i].getUsername().equals(username)) {
                    return customers[i];
                }
            }
        }
        return null;
    }


    // TODO: Ensure duplicates do not exist, while minimizing calls to doesUsernameExist method.
    /**
    public boolean makeUser(String username, String password, String phoneNumber, String email){
        if(!doesUsernameExist(username)){
            if((currentIndex + 1) < users.length){
                if(users[currentIndex+1] == null){
                    users[++currentIndex] = new Customer(ID, firstName, lastName, email, username, password);
                    return true;
                }
            }
        } else {
            System.out.println("user already exists");
        }
        return false;
    }
     */

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

    

    public Employee findEmployeeByUsername(String username) {


    }
}