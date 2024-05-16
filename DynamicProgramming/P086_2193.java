package DynamicProgramming;

import java.util.Scanner;

public class P086_2193 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long[][] dp = new long[2][n+1]; //int로 선언 시 범위 초과문제 발생

    dp[1][1] = 1;

    for(int i=2; i<=n; i++){
      dp[0][i] = dp[0][i-1] + dp[1][i-1];
      dp[1][i] = dp[0][i-1];
    }

    System.out.println(dp[0][n] + dp[1][n]);

  }

}
