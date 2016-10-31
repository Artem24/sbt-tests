/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tests.test5;

/**
 *
 * @author artem
 */
public class Main {

    public static void main(String[] args) {
        
        // true
        System.out.println("11-11-2016: " + isLeapYear("11-11-2016"));
        System.out.println("11-11-2012: " + isLeapYear("11-11-2012"));
        System.out.println("11-11-2020: " + isLeapYear("11-11-2020"));
        
        // true
        System.out.println("1-1-1600: " + isLeapYear("1-1-1600"));
        // false
        System.out.println("1-1-2100: " + isLeapYear("1-1-2100"));
        // false
        System.out.println("1-1-1700: " + isLeapYear("1-1-1700"));
        
    }
    
    public static boolean isLeapYear(String date){
        
        int position = date.lastIndexOf("-");
        int year = Integer.parseInt( date.substring(position) );
        
        if( ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0) )
            return true;
        
        return false;
    }
    
}
