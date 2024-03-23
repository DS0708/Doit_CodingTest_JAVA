package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P063_1389 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] graph = new int[n+1][n+1];
    int max = 1000000;  //Integer.MaxValue로 선언시 계산 과정에서 두개가 더해지면서 오버플로우가 발생한다.

    for(int i=1; i<=n; i++){
      for(int j=1; j<=n ; j++){
        if(i==j) continue;
        else graph[i][j] = max;
      }
    }

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      graph[s][e] = 1;
      graph[e][s] = 1;
    }

    //Floyd-warshall
    for(int k=1; k<=n; k++){
      for(int i=1; i<=n; i++){
        for(int j=1; j<=n ; j++){
          if(i==j) continue;
          else graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
    }

    int min = max;
    int result = -1;
    for(int i=1; i<=n; i++){
      int sum = 0;
      for(int j=1; j<=n ; j++){
        sum += graph[i][j];
      }
      if (min > sum){
        min = sum;
        result = i;
      }
    }
    System.out.println(result);
  }
}
