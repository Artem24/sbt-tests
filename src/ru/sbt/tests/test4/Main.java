/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tests.test4;



/**
 *
 * @author artem
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        TaskExecutor.asyncExecuteConcurrentTask();
        TaskExecutor.asyncExecuteExclusiveTask();
        TaskExecutor.asyncExecuteExclusiveTask();
        TaskExecutor.asyncExecuteExclusiveTask();
        TaskExecutor.asyncExecuteConcurrentTask();
        

        Thread.sleep(10000);
        TaskExecutor.shutDown();
        
    }
}
