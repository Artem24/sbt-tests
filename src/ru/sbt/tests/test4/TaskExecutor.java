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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaskExecutor {
	
	/**
	 * Потокобезопасное хранилище данных
	*/
	private static Collection<Object> dataStore = new ConcurrentHashSet<Object>();
	
	private static final String OK= "OK";
	
	private static final String FAIL = "FAIL";
        
        static ExecutorService es1 = Executors.newSingleThreadExecutor();
        
	/**
	 * Выполнение задания эксклюзивного типа Добавление данных в хранилище,
	 * если хотя бы один элемент уже существует, данные не добавляются
	 * @paramnewDataновые данные
	 * @return если хотя бы один элемент уже существует, возвращается результат с
	 *         ошибкой, иначе возвращается успешный результат
	*/
	private static String executeExclusiveTask(Collection<Object> newData) {
		for (Object element : newData) {
			if (dataStore.contains(element)) {
				return FAIL;
			}
		}
		dataStore.addAll(newData);
		return OK;
	}
	
	/**
	 * Выполнение задания параллельного типа.
	 * Добавление данных в хранилище,
	 * если элемент существует, в результат помещается информация,
	 * о том, что добавление элемента не произошло,
	 * в другом случает в результат помещается информация о успешном добавлении
	 * @paramnewData новые данные
	 * @returnданные по результатам добавления каждого их новых элементов
	*/
	private static Map<Object, String> executeConcurrentTask(Collection<Object> newData) {
		Map<Object, String> result = new HashMap<Object, String>();
		for (Object element : newData) {
			if (dataStore.contains(element)) {
				result.put(element, FAIL);
			} else {
				dataStore.add(element);
				result.put(element, OK);
			}
		}
		return result;
	}
	
	/**
	 * Выполнение задания первого типа в отдельном потоке 
	*/
	public static void asyncExecuteExclusiveTask() {
		
                es1.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Executing exclusive task...");
//                        TaskExecutor.executeConcurrentTask(dataStore);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            System.err.println("Exception: " + ex.getMessage());
                        }
                        
                        System.out.println("..exclusive task done.");
                    }
                });
		
	}
	
	/**
	 * Выполнение задания второго типа в отдельном потоке
	*/
	public static void asyncExecuteConcurrentTask() {
		
                es1.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Executing concurrent task...");
//                        TaskExecutor.executeConcurrentTask(dataStore);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            System.err.println("Exception: " + ex.getMessage());
                        }
                        
                        System.out.println("..concurrent task done.");
                    }
                });
	}
        
        public static void shutDown(){
            es1.shutdownNow();
        }

}

