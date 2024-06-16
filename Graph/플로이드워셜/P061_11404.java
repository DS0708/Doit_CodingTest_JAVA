package Graph.플로이드워셜;

import java.io.*;
import java.util.*;

public class P061_11404 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st ;
    int V = Integer.parseInt(br.readLine());
    int E = Integer.parseInt(br.readLine());

    int[][] graph = new int[V+1][V+1];
    for(int i=1; i<=V; i++) {
      Arrays.fill(graph[i],Integer.MAX_VALUE/3); //두 값을 더하는 로직이 존재하므로 Overflow에 주의해야 한다.
      graph[i][i] = 0;
    }

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[s][e] = Math.min(graph[s][e],v);
    }

    //플로이드 워셜 알고리즘
    //for문이 거쳐 가는 지점부터 시작되어야 하는 이유를 이해해야할 필요가 있음
    for(int k=1; k<=V; k++)
      for(int i=1; i<=V; i++)
        for(int j=1; j<=V; j++)
          graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);

    for(int i=1; i<=V; i++){
      for(int j=1; j<=V; j++){
        if(graph[i][j] == Integer.MAX_VALUE/3) bw.write(0+" ");
        else bw.write(graph[i][j]+" ");
      }
      bw.write("\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }
}
