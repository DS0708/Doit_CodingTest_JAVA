package Class2;

import java.util.Scanner;

public class P2609 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();

    int gcd = gcd(Math.max(a,b), Math.min(a,b));
    long lcm = a * b / gcd;

    System.out.println(gcd);
    System.out.println(lcm);

  }
  static int gcd(int a, int b){
    //gcd(G,0) = G
    //gcd(A,B) = gcd(B,r), A = Bk + r
    if (a%b ==0) {
      return b;
    }else{
      return gcd(b,a%b);
    }
  }
}
