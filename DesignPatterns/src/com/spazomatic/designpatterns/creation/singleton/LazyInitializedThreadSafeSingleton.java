package com.spazomatic.designpatterns.creation.singleton;

public class LazyInitializedThreadSafeSingleton {
	 
    private static LazyInitializedThreadSafeSingleton instance;
     
    private LazyInitializedThreadSafeSingleton(){}
     
    /*
     * synchronized methods may have performance impact as only one thread can call method at time.
     */
    public static synchronized LazyInitializedThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedThreadSafeSingleton();
        }
        return instance;
    }
 
}