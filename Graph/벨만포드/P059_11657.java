package Graph.벨만포드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge_11657{
  int s;
  int e;
  int v;
  Edge_11657(int s, int e, int v){
    this.s = s;
    this.e = e;
    this.v = v;
  }
}

public class P059_11657 {
  static ArrayList<Edge_11657> graph;
  static long[] dist;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    graph = new ArrayList<>();
    dist = new long[n+1];
    int start = 1;
    Arrays.fill(dist,Integer.MAX_VALUE);

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.add(new Edge_11657(s,e,v));
    }

    //결과 출력
    boolean check = BellmanFord(n,m,start);
    if(check){
      for(int i=2; i<=n; i++){
        if(dist[i]!=Integer.MAX_VALUE)  System.out.println(dist[i]);
        else System.out.println(-1);
      }
    }else{
      System.out.println(-1);
    }
  }

  public static boolean BellmanFord(int n, int m, int start){
    dist[start] = 0;
    boolean check = true;

    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        Edge_11657 now = graph.get(j);
        if(dist[now.s] != Integer.MAX_VALUE && dist[now.e] > dist[now.s] + now.v)
          dist[now.e] = dist[now.s] + now.v;
      }
    }

    for(int i=0; i<m; i++){
      Edge_11657 now = graph.get(i);
      if(dist[now.s] != Integer.MAX_VALUE && dist[now.e] > dist[now.s] + now.v){
        check =false;
        break;
      }
    }

    return check;
  }

}
