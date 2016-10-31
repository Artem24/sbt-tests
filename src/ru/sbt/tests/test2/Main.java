/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tests.test2;


/**
 *
 * @author artem
 */
public class Main {

    public static void main(String[] args) {
        
        for(int i = -10; i < 20; i++){
            System.out.println("p(" + i + ") = " + p(i));
        }
    }

    public static boolean p(int x){
        
        if(x % 3 == 0)
            return true;
        else
            return false;
    }
}
