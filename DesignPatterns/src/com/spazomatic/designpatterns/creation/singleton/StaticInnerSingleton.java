package com.spazomatic.designpatterns.creation.singleton;

public class StaticInnerSingleton {
 
    private StaticInnerSingleton(){}
     
    private static class ThreadSafeLazySingletonHelper{
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }
     
    public static StaticInnerSingleton getInstance(){
        return ThreadSafeLazySingletonHelper.INSTANCE;
    }
}