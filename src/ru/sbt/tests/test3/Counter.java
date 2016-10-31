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
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
        
        //private AtomicInteger value = new AtomicInteger();
        private int value;
        public int getValue(){
                return value;//.get();
        }
        public int increment(){
                //value.set(value.get()+1);
                return ++value;//.get();//.incrementAndGet();
        }

        // Alternative implementation as increment but just make the
        // implementation explicit
//        public int incrementLongVersion(){
//                int oldValue = value.get();
//                while (!value.compareAndSet(oldValue, oldValue+1)){
//                         oldValue = value.get();
//                }
//                return oldValue+1;
//        }

}
