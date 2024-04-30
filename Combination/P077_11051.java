package Combination;

import java.util.Scanner;

public class P077_11051 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int K = scanner.nextInt();
    int[][] C = new int[N+1][N+1];
    for(int i=0; i<=N; i++){
      C[i][0] = 1;
      C[i][1] = i;
      C[i][i] = 1;
    }
    for(int i=2; i<=N; i++){
      for(int j=2; j<i; j++){
        C[i][j] = C[i-1][j] + C[i-1][j-1];
        C[i][j] %= 10007;
      }
    }
    System.out.println(C[N][K]);
  }
}
