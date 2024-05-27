package DynamicProgramming;

import java.util.*;

public class P089_13398 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] A = new int[n+2];
    long[] L = new long[n+2];
    long[] R = new long[n+2];
    long result = Long.MIN_VALUE;

    for(int i=1; i<=n; i++){
      A[i] = scan.nextInt();
    }
    // 왼쪽 합 구하기
    for(int i=1; i<=n; i++){
      L[i] = Math.max(A[i], L[i-1] + A[i]);
      result = Math.max(result,L[i]); // 수열에서 수를 제거하지 않았을 때의 최댓값
    }
    // 오른쪽 합 구하기
    for(int i=n; i>=1; i--){
      R[i] = Math.max(A[i], R[i+1] + A[i]);
    }
    // 수 하나 제거 했을 떄 최댓값 구하기  : L[i-1] + R[i+1]
    for(int i=1; i<=n; i++){
      if(n!=1)  result = Math.max(result, L[i-1] + R[i+1]); // n이 1이고 A[1]이 음수일때 예외처리
    }
    System.out.println(result);
  }
}
