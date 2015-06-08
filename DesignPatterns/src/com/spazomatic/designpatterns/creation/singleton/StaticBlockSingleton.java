package com.spazomatic.designpatterns.creation.singleton;

/*
 * Same as Eager Initialized except has option for exception handling
 */
public class StaticBlockSingleton {
	 
    private static StaticBlockSingleton instance;
     
    private StaticBlockSingleton(){}
     
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
     
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
