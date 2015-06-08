package com.spazomatic.designpatterns.creation.singleton;

/*
 * Joshua Bloch suggests the EnumSingleton
 * Does not allow lazy implementation.
 * Per java, enums are only instantiated once
 */
public enum EnumSingleton {
 
    INSTANCE;
     
    public static void doSomething(){
        //do something
    }
}
