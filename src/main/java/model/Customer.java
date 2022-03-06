/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import model.LambdaExpression.addComma;


/**
 * The class of customer with private class fields: id, name, surrname, mail, city, street, house number, country and list of ordered items ids
 * @author Michał Kalke
 */
public class Customer {
    private Integer id; // represents id of the customer
    private String name; // represents the first name of the customer
    private String lastName; // represents the surrname of the customer
    private String mail; // has the mail of the customer
    private String city; // has the city where the customer lives
    private String street; // represents the street on which customer lives
    private String houseNumber; // has the numer of customer's house
    private String country; // has the country in which the customer lives
    private String orders; // has ids of all ordered items 
    
    /**
     * Constructor without agruments
     */
    public Customer(){
    }
    
    /**
     * Constructor with eight arguments
     * @param id has the id of client in base
     * @param name stores the first name of client
     * @param lastName stores the surrname of client
     * @param mail stores the mail adress of client
     * @param city stores the city where the client lives
     * @param street stores the client's street
     * @param houseNumber stores the client's house number
     * @param country stores the country where client lives
     */
    public Customer(Integer id,String name, String lastName, String mail, String city, String street, String houseNumber, String country) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.country = country;
    }
    /**
     * Constructor with eight arguments
     * @param id has the id of client in base
     * @param name stores the first name of client
     * @param lastName stores the surrname of client
     * @param mail stores the mail adress of client
     * @param city stores the city where the client lives
     * @param street stores the client's street
     * @param houseNumber stores the client's house number
     * @param country stores the country where client lives
     * @param orders stores the ids of client's ordered items
     */
    public Customer(Integer id,String name, String lastName, String mail, String city, String street, String houseNumber, String country, String orders) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.country = country;
        this.orders = orders;
    }

    /**
     * Setter of city of the customer
     * @param city passed new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Setter of street of the customer
     * @param street passed new street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Setter of the house number of the customer
     * @param houseNumber passed new house number
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Setter of orders of the customer
     * @param orders passed new orders
     */
    public void setOrders(String orders) {
        this.orders = orders;
    }
    
    /**
     * Getter returning id of the client
     * @return id
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     * Getter returning the first name of the client
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter returing last name of the client
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * Getter returing the mail address of the client
     * @return mail
     */
    public String getMail() {
        return this.mail;
    }
    
    /**
     * Getter returning the city where client lives
     * @return city
     */
    public String getCity() {
        return this.city;
    }
    
    /**
     * Getter returning the street where client lives
     * @return street
     */
    public String getStreet() {
        return this.street;
    }
    
    /**
     * Getter returning the client's house number
     * @return houseNumber
     */
    public String getHouseNumber() {
        return this.houseNumber;
    }
    
    /**
     * Getter returning the country where client lives
     * @return country 
     */
    public String getCountry() {
        return this.country;
    }
    
    /**
     * Getter returning list of ids of items that client bought
     * @return listOfOrders
     */
    public String getOrders() {
        return this.orders;
    }
    
    /**
     * This method is adding new order with lambda expression
     * @param i stores the number of item which client bought
     */
    public void addNewOrder(Integer i) {
        LambdaExpression mainObject = new LambdaExpression();
        addComma addition = (a, str) -> a+str;
        this.orders = this.orders + mainObject.add(i, ", ", addition);
    }
    
    /**
     * This method shows all orders of the client
     */
    public void showOrders() {
       // for(Integer i : this.listOfOrders) {
            System.out.println(this.orders);
        //}
    }

    
    /**
     * This method is checking if there is given customer in list, if yes it returns true
     * @param listOfCustomers stores list of customers
     * @param name stores the first name of the given customer
     * @param lastName stores the last name of given customer
     * @param city stores the city where customer lives
     * @param country stores the country where given customer lives
     * @return boolean
     */
    public boolean checkIfIsInBase(List<Customer> listOfCustomers, String name, String lastName, String city, String country) {
        for(Customer c: listOfCustomers) {
            if(c.getName().equals(name)&&c.getLastName().equals(lastName)&&c.getCountry().equals(country)&&c.getCity().equals(city)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method is searching and returning the id of given customer
     * @param listOfCustomers stores list of customers
     * @param name stores the first name of the given customer
     * @param lastName stores the last name of given customer
     * @param city stores the city where customer lives
     * @param country stores the country where given customer lives
     * @return id
     */
    public Integer findIdOfCustomer(List<Customer> listOfCustomers, String name, String lastName, String city, String country) {
        for(Customer c: listOfCustomers) {
            if(c.getName().equals(name)&&c.getLastName().equals(lastName)&&c.getCountry().equals(country)&&c.getCity().equals(city)) {
                return c.id;
            }
        }
        return 0;
    }
    
    /**
     * This method is adding order to given customer by id, if order is negative or equal to zero, this throws an exception
     * @param listOfCustomers stores list of customers
     * @param order stores order which will be added to the customer
     * @param id  stores id of the customer
     * @throws integerException is thrown when order number is less than 1
     */
    public void addOrder(List<Customer> listOfCustomers, Integer order, Integer id) throws integerException {
        if(order < 1) {
            throw new integerException("Podano ujemny bądź zerowy numer zamównienia!"); 
        }else {
            for(Customer c: listOfCustomers) {
                if(c.getId()==id) {
                    c.addNewOrder(order);
                    
                }
            }
        }
        
    }
    
    /**
     * This method is returning the last id number in list of customers
     * @param listOfCustomers stores list of customers
     * @return last
     */
    public Integer lastIdInBase(List<Customer> listOfCustomers) {
        Customer customer = Collections.max(listOfCustomers, Comparator.comparing(s->s.getId()));
        Integer last = customer.getId();
        return last;
    }
    
    /**
     * This method is removing given customer from list, if id is not in the list it throws an own exception
     * @param listOfCustomers stores list of customers
     * @param id stores id number of given customer
     */
    public void removeFromList(List<Customer> listOfCustomers, Integer id) { 
        listOfCustomers.stream().filter(c -> (Objects.equals(c.getId(), id))).forEachOrdered(c -> {
            listOfCustomers.remove(c);
        });
    }

}


 
