/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is holding customer objects in an array list
 * @author Michał Kalke
 */
public class Customers {
    private final List<Customer> data; //holding customer objects in a list

    /**
     * Constructor where data from txt file become a customer object and is added to the list
     */
    public Customers() {
       data = new ArrayList<Customer>();

               try {
      File file = new File("customer"+".txt");
      Scanner myReader = new Scanner(file);
      while (myReader.hasNextLine()) {
        String dataA = myReader.nextLine();
        Integer id = Integer.parseInt(dataA.split("\\;")[0]);
         String name = dataA.split("\\;")[1];
         String lastName = dataA.split("\\;")[2];
         String mail = dataA.split("\\;")[3];
         String city= dataA.split("\\;")[4];
         String street =dataA.split("\\;")[5];
         String houseNumber =dataA.split("\\;")[6];
         String country = dataA.split("\\;")[7];
         String orders = dataA.split("\\;")[8];
         data.add(new Customer(id, name, lastName, mail, city, street, houseNumber, country, orders));
      }
      myReader.close();
    } 
      catch (FileNotFoundException e) {
         //System.out.println("An error occurred.");
         //e.printStackTrace();
        }
    }

    /**
     * Getter of the data parameter
     * @return returning data
     */
    public List<Customer> getData() {
        return data;
    }
}
