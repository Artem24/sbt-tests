/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tests.test6;

/**
 *
 * @author artem
 */


public class MyLinkedList<E> {
    
    private MyLinkedList<E> next;
    private Object value;

    public MyLinkedList<E> getMiddleElement(MyLinkedList<E> start){
        MyLinkedList pos = start;

        while(start != null && start.next != null){
            start = start.next;
            pos = start.next;
        }
        
        return start;
    }

}

