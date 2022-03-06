/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.LinkedList;
import java.util.List;
import model.Customer; 
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



/**
 * The class of junit tests on the model of the program
 * @author Michal Kalke
 */
public class CustomerTests {
    
    List list = new LinkedList<Customer>(); // represents list of customers
    List listOfOrders = new LinkedList<Integer>(); // represents list of customer's orders
    
    Customer c;  // represents first customer
    Customer c2; // represents second customer
    Customer c3; // represents third customer

   /**
    * This method is called before each test and is used to give initial values
    */
    @BeforeEach
    public void setUp() {
        //listOfOrders.add(1);
        c = new Customer(3, "Michal", "Kalke", "michalszef@wp.pl", "Koty", "Ogr", "20", "Polska", "1,2,3");
        //listOfOrders.add(3);
        c3 = new Customer(7, "Tom", "Ek", "tome@gmail.com", "St", "Husa", "13", "Polska", "5");
       // listOfOrders.add(979);
        c2 = new Customer(1, "Mich", "Kal", "mika@gmail.com", "Koty", "Ogro", "20", "Polska", "9");
        list.add(c);
        list.add(c2);
        list.add(c3);
    }
    
    /**
     * This is parametrized test that is checking if method checkIfIsInBase works as it should be, in this test, parameters are correct
     * @param name stores correct test name
     * @param lastName stores correct test surrname
     * @param city stores correct test city
     * @param country stores correct test country
     */
    @ParameterizedTest
    @CsvSource({"Michal, Kalke, Koty, Polska", "Tom, Ek, St, Polska", "Mich, Kal, Koty, Polska"})
    public void checkIfIsInBaseTestTrue(String name, String lastName, String city, String country) {
        assertTrue(c.checkIfIsInBase(list, name, lastName, city, country));
    }
    
    
    /**
     * This is parametrized test that is checking if method checkIfIsInBase works as it should be, in this test, one of the parameters is incorrect
     * @param name stores test name
     * @param lastName stores test surrname
     * @param city stores test city
     * @param country stores test country
     */
    @ParameterizedTest
    @CsvSource({"Michal, Klke, Koty, Polska", "Tom, Ee, St, Polska", "Mich, Kal, Koy, Polska"})
    public void checkIfIsInBaseTestFalse(String name, String lastName, String city, String country) {
        assertFalse(c.checkIfIsInBase(list, name, lastName, city, country));
    }
    
    /**
     * This is parametrized test that is checking if method findIdOfCustomer works as it should be, in this test, all parameters are correct
     * @param id stores correct test id
     * @param name stores correct test name
     * @param lastName stores correct test surrname
     * @param city stores correct test city
     * @param country stores correct test country
     */
     @ParameterizedTest
     @CsvSource({"3, Michal, Kalke, Koty, Polska", "7, Tom, Ek, St, Polska", "1, Mich, Kal, Koty, Polska"})
    public void findIdOfCustomerTestCorrect(Integer id, String name, String lastName, String city, String country) {
        assertEquals(id, c.findIdOfCustomer(list, name, lastName, city, country));
    }
    
    
    /**
     * This is parametrized test that is checking if method findIdOfCustomer works as it should be, in this test, one of the parameters is incorrect
     * @param id stores test id
     * @param name stores test name
     * @param lastName stores test surrname
     * @param city stores test city
     * @param country stores test country
     */
     @ParameterizedTest
     @CsvSource({"3, Michl, Kalke, Koty, Polska", "7, Tom, Eke, St, Polska", "1, Mich, Kal, Ploty, Polska"})
    public void findIdOfCustomerTestIncorrect(Integer id, String name, String lastName, String city, String country) {
        assertEquals(0, c.findIdOfCustomer(list, name, lastName, city, country));
    }
    
    /**
     * Non parametrized test than is checking if method lastIdInBase returns the last id in the base
     */
    @Test
    public void lastIdInBaseTest() {
        assertEquals(7, c2.lastIdInBase(list));
    }
    /**
     * This is parametrized test that is checking if method removeFromList works as it should be
     * @param numberOfClients stores number of clients which should accure after removing from the base
     * @param clientId stores id of the client
     */
    @ParameterizedTest
    @CsvSource({"2, 7", "1, 3", "0, 1"})
    public void removeFromListTest(Integer numberOfClients, Integer clientId) {
        c3.removeFromList(list, clientId);
        assertEquals(numberOfClients, list.size());
    }
 
}
