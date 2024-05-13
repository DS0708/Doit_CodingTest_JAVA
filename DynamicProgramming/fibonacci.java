package DynamicProgramming;

import java.util.Scanner;

public class fibonacci {
  static int[] D;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    D = new int[n+1];

    for(int i=0; i<=n ; i++){
      D[i] = -1;
    }

    D[0] = 0;
    D[1] = 1;

    //fiboTopDown(n);
    fiboBottomUp(n);

    System.out.println(D[n]);
  }

  static void fiboBottomUp(int n){
    for(int i=2; i<=n; i++){
      D[i] = D[i-1] + D[i-2];
    }
  }

  static int fiboTopDown(int n){
    if (D[n] != -1) //기존에 계산한 적이 있는 부분의 문제는 재계산하지 않고 리턴
      return D[n];

    // Memoization : 구한 값을 바로 리턴하지 않고 DP 테이블에 저장한 후 리턴하도록 로직을 구현
    return D[n] = fiboTopDown(n-1) + fiboTopDown(n-2);
  }
}
