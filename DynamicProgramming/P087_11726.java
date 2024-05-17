package DynamicProgramming;

import java.util.*;

public class P087_11726 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[][] D = new int[n+1][2];
    int mod = 10007;
    // 세로로 끝나는거 0, 가로로 끝나는거 1
    D[1][0] = 1;
    D[1][1] = 0;

    for(int i=2; i<=n; i++){
      D[i][0] = (D[i-1][0] + D[i-1][1])%mod;
      D[i][1] = D[i-1][0]%mod;
    }

    int result = (D[n][0] + D[n][1]) % mod;

    System.out.println(result);
  }
}
