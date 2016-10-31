/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tests.test3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author artem
 */
public class MyBoundedQueue<E> {
    
    static class Node<E> {
        E element;
        AtomicReference<Node<E>> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = new AtomicReference<>(next);
        }
    }
    
    private final int max_size;
    private AtomicInteger current_size = new AtomicInteger(0);
    
    private AtomicReference<Node<E>> head;
    private AtomicReference<Node<E>> tail;

    public MyBoundedQueue(int max_size) {
        head = tail = new AtomicReference<>(new Node<E>(null, null));
        this.max_size = max_size;
    }
    
    // Пытается добавить элемент в хвост очереди
    // Возвращает true при успешном добавлении,
    // false при невозможности добавления из-за достижения максимального размера очереди
    // или при попытке добавить пустой элемент (null)
    public boolean offer(E element){
        
        if(current_size.get() == max_size || element == null)
            return false;
        
        Node<E> newNode = new Node<>(element, null);
        
        while(true){
            Node<E> curTail = tail.get();
            Node<E> residue = curTail.next.get();
            
            if(curTail == tail.get()){
                if(residue == null){
                    if(curTail.next.compareAndSet(null, newNode)){
                        tail.compareAndSet(curTail, newNode);
                        current_size.incrementAndGet();
                        return true;
                    }
                } else {
                    tail.compareAndSet(curTail, residue);
                }
            }
            
        }

    }
    
    // Извлекает головной элемент из очереди с удалением
    // Возвращает головной элемент в случае успеха или null в случае пустой очереди
    public E poll(){
        
        while(true){
            Node<E> h = head.get();
            Node<E> t = tail.get();
            Node<E> first = h.next.get();
            
            if(h == head.get()){
                if(h == t){
                    if (first == null)
                        return null;
                    else
                        tail.compareAndSet(t, first);
                } else if(head.compareAndSet(h, first)) {
                    E element = first.element;
                    if(element != null){
                        first.element = null;
                        current_size.decrementAndGet();
                        return element;
                    }
                }
            }
        }
        
    }
    
    // Извлекает головной элемент из очереди без удаления
    // Возвращает головной элемент в случае успеха или nullв случае пустой очереди
    public E peek(){
        
        while(true){
            Node<E> h = head.get();
            Node<E> t = tail.get();
            Node<E> first = h.next.get();

            if(h == head.get()){
                if(h == t){
                    if (first == null)
                        return null;
                    else
                        tail.compareAndSet(t, first);
                } else {
                    E element = first.element;
                    if(element != null){
                       // first.element = null;
                        return element;
                    } else {
                        head.compareAndSet(h, first);
                    }
                }
            }
        }
        
    }

    public int getMax_size() {
        return max_size;
    }

    public int getCurrent_size() {
        return current_size.get();
    }

    
    
}
