package com.exception;

public class Demo {
 public static void main(String[] args) {
   double res = div(2, 1);
   System.out.println(res);
   res = div(2, 0);
   System.out.println(res);
 }

 public static double div(int a, int b) {
   try {
     double res = a / b;
     System.out.println("in try block.");
     return res;
   } catch(ArithmeticException e) {
     System.out.println("in ATE catch block.");
     return -1.0;
   } finally {
     System.out.println("in finally block.");
   }
 }
}