package DynamicProgramming;

import java.util.Scanner;

public class P088_10844 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long[][] D = new long[n][10];
    int mod = 1000000000;
    long sum = 0;

    for(int i=1; i<=9; i++){
      D[0][i] = 1;
    }

    for(int i=1; i<n; i++){
      D[i][0] = D[i-1][1];
      for(int j=1; j<=8; j++){
        D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % mod;
      }
      D[i][9] = D[i-1][8];
    }

    for(int i=0; i<=9; i++){
      sum += D[n-1][i];
    }

    System.out.println(sum%mod);
  }
}
