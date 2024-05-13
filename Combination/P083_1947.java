package Combination;

import java.util.Scanner;

public class P083_1947 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long[] derangement = new long[n+1];
    derangement[1] = 0;

    if(n >= 2)  //n이 1일 때 derangement[2] 는 없음
      derangement[2] = 1;

    for(int i=3; i<=n; i++){
      derangement[i] = (i-1) * (derangement[i-1] + derangement[i-2]) % 1000000000;
      // (a + b) mod c = (a mod c + b mod c) mod c
      // (a * b) mod c = (a mod c * b mod c) mod c
    }

    System.out.println(derangement[n]);
  }
}
