package com.sms.sandbox.functional.recursion;
class HeadVsTail {
   public static void main(String[] args) {     
      printUsingHeadRecursion(5);
      printUsingTailRecursion(5);
   }

   static void printUsingHeadRecursion(int n){
      if(n == 0) {
    	  System.out.println("Head Returns");
         return;
      }else {
    	  printUsingHeadRecursion(n-1); 
      }
      System.out.println(n);
   }
   
   static void printUsingTailRecursion(int n) {
	   if(n == 0) {
		   System.out.println("Tail Returns");
		   return;
	   }else {
		   System.out.println(n);
	   }
	   printUsingTailRecursion(n - 1);
   }
}