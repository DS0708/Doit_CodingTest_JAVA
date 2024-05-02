package Combination;

import java.util.Scanner;

public class P078_2775 {
  public static void main(String[] args) {
    // apartment[k][n] = apartment[k-1][n] + apartment[k][n-1];
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] apartment = new int[15][15];
    for(int i=0; i<=14; i++){
      apartment[0][i] = i;
    }
    for(int i=1; i<=14; i++){
      for(int j=1; j<=14; j++){
        apartment[i][j] = apartment[i-1][j] + apartment[i][j-1];
      }
    }
    for(int i=0;i<n; i++){
      int k = scanner.nextInt();
      int ho = scanner.nextInt();
      System.out.println(apartment[k][ho]);
    }
  }
}
