package com.spazomatic.designpatterns.creation.singleton;

public class BillPughStaticInnerSingleton {
 
    private BillPughStaticInnerSingleton(){}
     
    private static class ThreadSafeLazySingletonHelper{
        private static final BillPughStaticInnerSingleton INSTANCE = new BillPughStaticInnerSingleton();
    }
     
    public static BillPughStaticInnerSingleton getInstance(){
        return ThreadSafeLazySingletonHelper.INSTANCE;
    }
}