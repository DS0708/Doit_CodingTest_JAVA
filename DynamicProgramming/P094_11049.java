package DynamicProgramming;

import java.util.Scanner;

public class P094_11049 {
  static Matrix[] tensor;
  static int N;
  static int[][] dp;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    tensor = new Matrix[N+1];
    dp = new int[N+1][N+1];
    // 메모이제이션을 위해 -1로 초기화
    for(int i=0; i<dp.length; i++){
      for(int j=0; j<dp[i].length; j++){
        dp[i][j] = -1;
      }
    }
    //입력 받기
    for(int i=1; i<=N; i++){
      int a = scan.nextInt();
      int b = scan.nextInt();
      tensor[i] = new Matrix(a,b);
    }
    System.out.println(executeDP(1,N));
  }

  static int executeDP(int start, int end){
    int result = Integer.MAX_VALUE;

    //이미 설정된 값이면 보지 않음
    if(dp[start][end] != -1) return dp[start][end];

    if(start==end){
      //start와 end가 같으면 0
      result = 0;
    }else if(start + 1 == end){
      //하나 차이 날 경우, 경우의 수는 1 개 !
      result = tensor[start].row * tensor[start].col * tensor[end].col;
    }else{
      //2개 이상 차이날 경우, 부분의 경우의 수를 구해야함
      //왼쪽 부분 경우의 수와 오른쪽 부분 경우의 수와 두 개를 합치는 데 드는 비용을 더한 값으로 초기화
      for(int i=start; i<end; i++){
       result = Math.min(result, executeDP(start,i) + executeDP(i+1,end) + tensor[start].row*tensor[i].col*tensor[end].col ) ;
      }
    }

    return dp[start][end] = result;
  }
}

class Matrix{
  int row;
  int col;
  Matrix(int row, int col){
    this.row = row;
    this.col = col;
  }
}

