/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tests.test3;



/**
 *
 * @author artem
 */
public class Main {

    public static void main(String[] args) {
        
        MyBoundedQueue queue = new MyBoundedQueue(3);
        
        for(int i = 0; i < 5; i++){
            boolean result = queue.offer("element " + i);
            if(result == false)
                System.out.println("Offer fails on " + i + " element");
            else
                System.out.println("Offer element "  + i);
        }
        
        System.out.println("Current size is " + queue.getCurrent_size());
        System.out.println("Max size is " + queue.getMax_size());
        
        System.out.println("Peeked element is " + (String) queue.peek());
        
        System.out.println("Current size is " + queue.getCurrent_size());
        System.out.println("Max size is " + queue.getMax_size());

        for(int i = 0; i < 5; i++){

            System.out.println("Polled element is " + (String) queue.poll());
            System.out.println("Current size is " + queue.getCurrent_size());
            System.out.println("Max size is " + queue.getMax_size());
        }
    }
}
