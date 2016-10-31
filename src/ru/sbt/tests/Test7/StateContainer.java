/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.tests.Test7;

import java.util.Map;

/**
 *
 * @author artem
 */
class StateContainer
{
    private Map<Object, MyObject> state;

    public StateContainer()
    {
//        1 state = new HashMap()
//        2 state = new SynchronizedHashMap()
//        3 state = new HashMap()/ConcurrentHashMap()
//        4 state = new ConcurrentHashMap()
        
    }

    public MyObject updateObject(String id, MyObject o)
    {
        return state.put(id, o);
    }

    public MyObject getObject(String id)
    {
        return state.get(id);
    }

}
