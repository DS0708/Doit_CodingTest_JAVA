package Greedy;

import java.util.*;

public class P032_11047 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt();
    int count = 0;
    int[] coin = new int[n];
    for(int i=0; i<n; i++)
      coin[i] = scan.nextInt();
    for(int i=n-1; i>=0; i--){
      if(k >= coin[i]){
        count += k/coin[i];
        k %= coin[i];
      }
      if(k==0) break;
    }

    System.out.println(count);
  }
}
