package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P061_11404 {
  static int Max = 1000000;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st ;
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    long[][] graph = new long[n+1][n+1];
    // graph에서 자기 자신한테 오는 값들은 0, 그 이외에는 최대범위 수로 초기
    for(int i=1; i<=n ; i++){
      for(int j=1; j<=n; j++){
        if (i==j) graph[i][j] = 0;
        else graph[i][j] = Max;
      }
    }
    // graph input
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[s][e]  = Math.min(graph[s][e],v); //최소값을 저장해야 함에 주의 할 것
    }

    //Floyd-Warshall
    for(int k=1; k<=n; k++){
      for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
        }
      }
    }

    //output
    for(int i=1; i<=n ; i++){
      for(int j=1; j<=n; j++){
        if(graph[i][j] == Max) bw.write("0 ");
        else bw.write(graph[i][j]+" ");
      }
      bw.write('\n');
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
