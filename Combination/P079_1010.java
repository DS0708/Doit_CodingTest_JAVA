package Combination;

import java.util.Scanner;

public class P079_1010 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int max = 30;
    int[][] combi = new int[30][30];

    for (int i=0; i<30; i++){
     combi[i][0] = 1;   //nC0 = 1
     combi[i][1] = i;   //nC1 = n
     combi[i][i] = 1;   //nCn = 1
    }

    for(int i=1; i<30; i++){
      for(int j=1; j<i; j++){
        combi[i][j] = combi[i-1][j] + combi[i-1][j-1];
      }
    }

    int T = scan.nextInt();

    for(int i=0; i<T; i++){
      int a = scan.nextInt();
      int b = scan.nextInt();
      System.out.println(combi[b][a]);
    }

  }
}
