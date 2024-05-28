package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P091_1915 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] dp = new int[n+1][m+1];
    int answer=0;

    for(int i=1; i<=n; i++){
      String str = br.readLine();
      for(int j=1; j<=m; j++){
        dp[i][j] = str.charAt(j-1) - '0';
      }
    }

    for(int i=1; i<=n; i++){
      for(int j=1; j<=m; j++){
        if(dp[i][j]==1){
          dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
          answer = Math.max(answer,dp[i][j]);
        }
      }
    }

    System.out.println(answer*answer);
  }
}
