package DynamicProgramming;

import java.util.*;

public class P093_2342 {
  public static void main(String[] args) {
    int[][] cost = {
            {0,2,2,2,2},
            {0,1,3,4,3},
            {0,3,1,3,4},
            {0,4,3,1,3},
            {0,3,4,3,1},
    };
    Scanner scan = new Scanner(System.in);
    int[][][] dp = new int[100001][5][5];

    //dp를 충분히 큰 수로 초기화, N 번 시행했을 때 최대는 대략 100001 * 4번
    for(int i=0; i<5; i++)
      for(int j=0; j<5; j++)
        for(int k=0; k<100001; k++)
          dp[k][i][j] = 100001 * 10;

    //dp[0][0][0] 0번째 시작을 0으로 초기화
    dp[0][0][0] = 0;
    int cur = 1; // 진행 단계 변수

    while(true){
      int n = scan.nextInt();
      //0이면 수열의 끝이므로 break
      if(n==0) break;
      // i = 왼발, j = 오른발
      //왼발을 움직여서 n이 되었을 때 구하기
      for(int j=0; j<5; j++){
        if(j==n) continue; //오른발이랑 왼발은 같은 위치가 될 수 없음
        for(int i=0; i<5; i++){
          //왼발을 i->n으로 움직였을 때의 모든 경우의 수 구하기, 기존에 지나오지 않은 길일 경우 값은 매우 크기 때문에 걱정할 필요 없다.
          dp[cur][n][j] = Math.min(dp[cur][n][j], dp[cur-1][i][j] + cost[i][n]);
        }
      }
      //이제 오른발 차례, j->n 으로 이동
      for(int i=0; i<5; i++){
        if(i==n) continue;
        for(int j=0; j<5; j++){
          dp[cur][i][n] = Math.min(dp[cur][i][n], dp[cur-1][i][j] + cost[j][n]);
        }
      }
      cur++;
    }
    cur--; //총 시행한 횟수 구하기

    //이제 총 시행한 횟수 중에서 제일 최솟값을 구하면 끝
    int min = Integer.MAX_VALUE;
    for(int i=0; i<5; i++){
      for(int j=0; j<5; j++){
        min = Math.min(min,dp[cur][i][j]);
      }
    }

    System.out.println(min);
  }
}
