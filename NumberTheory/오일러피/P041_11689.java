package NumberTheory.오일러피;

import java.util.Scanner;

public class P041_11689 {
  public static void main(String[] args) {
   Scanner scan = new Scanner(System.in);
   long n = scan.nextLong();
   long result = n;
   long p = 2;

   while( p * p <= n){
     if(n%p==0){
       result -= result/p;
       while(n%p == 0){
         n /= p;
       }
     }
     p++;
   }

   if(n > 1){
     result -= result/n;
   }

   System.out.println(result);
  }
}
