package NumberTheory;

import java.util.Scanner;

public class P045_21568 {
  static long X,Y,A,B,C;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    A = scanner.nextLong();
    B = scanner.nextLong();
    C = scanner.nextLong();
    long gcd = gcd(A,B);

    if (C%gcd != 0){
      System.out.println(-1);
    }else {
      if (A%B != 0)
        expansionGCD(0,1,1,-A/B,B,A%B);
      else{
        X = 0;
        Y = 1;
      }
      System.out.print(X*C/gcd+" ");
      System.out.print(Y*C/gcd);
    }
  }

  public static long gcd(long A, long B){
    if (B==0) return A;
    else return gcd(B,A%B);
  }

  public static void expansionGCD(long x1, long x2, long p1, long p2, long p3, long p4){
    long q, rest;
    q = p3/p4;
    rest = p3%p4;

    if (rest == 0){
      X = p1;
      Y = p2;
    }else {
      expansionGCD(p1,p2,x1-q*p1,x2-q*p2,q,rest);
    }
  }

}
