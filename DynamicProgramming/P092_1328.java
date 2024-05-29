package DynamicProgramming;

import java.util.Scanner;

public class P092_1328 {
  public static void main(String[] args) {
    //제일 큰거부터 배치한다고 생각하면
    //그 다음 작은 것을 배치할때, 제일 왼쪽에 배치하는 경우는 N-1 L-1 R 의 경우의 수와 같고
    //오른쪽에 배치하는 경우는 N-1 L R-1 의 경우의 수와 같고
    //나머지에 배치하면 무조건 안보일테니 N-1 L R 에 N-2를 곱한 수가 경우의 수이다.
    //따라서 점화식은 DP[N][L][R] = D[N-1][L-1][R] + D[N-1][L][R-1] + D[N-1][L][R] * (N-2)
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int left = scanner.nextInt();
    int right = scanner.nextInt();
    long[][][] DP = new long[n+1][left+1][right+1];
    DP[1][1][1] = 1; //건물이 1개일때 왼쪽 오른쪽이 1개씩 보이는 경우의 수는 1
    long mod = 1000000007;

    for(int i=2; i<=n; i++){
      for(int j=1; j<=left; j++){
        for(int k=1; k<=right; k++){
          DP[i][j][k] = (DP[i-1][j-1][k] + DP[i-1][j][k-1] + DP[i-1][j][k]*(i-2))%mod;
        }
      }
    }

    System.out.println(DP[n][left][right]);
  }
}
