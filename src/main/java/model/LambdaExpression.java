/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *Lambda expression class
 * @author Michal Kalke
 */
public class LambdaExpression {
    
    /**
     * Specification of the lambda expression with two parameters
     */
    interface addComma {
        String method(int a,String str);
    }
    
    /**
     * Method add which takes above interface as a paramter
     * @param a int parameter
     * @param str string parameter
     * @param comma interface parameter
     * @return returns method from interface addDot
     */
    public String add(int a,String str, addComma comma) {
        return comma.method(a,str);
    }
}
