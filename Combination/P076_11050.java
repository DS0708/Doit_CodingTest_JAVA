package Combination;

import java.util.Scanner;

public class P076_11050 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int K = scan.nextInt();
    int[][] Combination = new int[N+1][N+1];
    for (int i=0; i<=N; i++){
      Combination[i][0] = 1;
      Combination[i][i] = 1;
      Combination[i][1] = i;
    }
    //Dynamic
    for(int i=2; i<=N; i++){
      for(int j=2; j<i; j++){
        Combination[i][j] = Combination[i-1][j] + Combination[i-1][j-1];
      }
    }
    System.out.println(Combination[N][K]);
  }
}
