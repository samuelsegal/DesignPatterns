package com.sms.sandbox.functional.function.chaining;
import java.util.function.Function;
public class ComposeVsAndThen {
   public static void main(String[] args) {
      Function<Integer, Integer> multiply = t -> t *3;
      Function<Integer, Integer> add = t -> t  + 3;
      Function<Integer, Integer> FirstMultiplyThenAdd = multiply.andThen(add);
      Function<Integer, Integer> FirstAddThenMultiply = multiply.compose(add);
      System.out.println(FirstMultiplyThenAdd.apply(3));
      System.out.println(FirstAddThenMultiply.apply(3));
   }
}