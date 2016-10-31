/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tests.test1;

/**
 *
 * @author artem
 */
public class Main {

    public static void main(String[] args) {
        
        char[] str1 = "abcde".toCharArray();
        System.out.println("Input string: " + String.valueOf(str1));
        strrev(str1);
        System.out.println("Reverse string: " + String.valueOf(str1));
    }

    public static void strrev(char[] str){
        
        int len = str.length;
        for(int i = 0; i < len / 2; i++){
            char temp = str[i];
            str[i] = str[len - i - 1];
            str[len - i - 1] = temp;
        }
        
    }
}
