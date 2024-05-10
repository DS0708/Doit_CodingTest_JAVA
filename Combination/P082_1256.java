package Combination;

import java.util.Scanner;

public class P082_1256 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    long[][] combi = new long[n+m+1][n+m+1];

    for(int i=0; i<=n+m; i++){
      combi[i][0] = 1;
      combi[i][1] = i;
      combi[i][i] = 1;
    }
    for(int i=1; i<=n+m; i++){
      for(int j=1; j<i; j++){
        combi[i][j] = combi[i-1][j] + combi[i-1][j-1];
        if(combi[i][j] > 1000000000) combi[i][j] = 1000000001;
        // 200 C 200 까지 하면 long값을 훨씬 초과하기 때문에 일정 수준에서 멈추게 하는 코드가 필요하다.
      }
    }

    if(combi[n+m][n] < k) {
      System.out.println(-1);
    }else{
      int a = n;
      int z = m;
      for(int i=1; i<=n+m; i++){
        long t = combi[a-1+z][z];
        if (t >= k){
          System.out.print("a");
          a--;
        }else{
          System.out.print("z");
          k -= t;
          z--;
        }
      }
    }
  }
}
