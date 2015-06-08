package com.spazomatic.designpatterns.creation.singleton;
/*
 * not thread safe as 2 threads may create at same time in getInstance
 */
public class LazyInitializedSingleton {
	 
    private static LazyInitializedSingleton instance;
     
    private LazyInitializedSingleton(){}
     
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
