/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 * The class of own exception which is extending build-in Exception class. This class has two constructors
 * @author Michał Kalke
 */
    public class integerException extends Exception {
        public integerException(){
        }
        
        public integerException(String message){
            super(message);
        }
    }
