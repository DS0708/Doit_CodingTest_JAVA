package Graph.그래프의표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P048_1707 {
  static boolean visited[];
  static int check[];
  static ArrayList<Integer> graph[];
  static boolean isEven;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());

    for (int i=0; i<K; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      isEven = true;

      visited = new boolean[V+1];
      graph = new ArrayList[V+1];
      check = new int[V+1];

      for(int j=1; j<=V; j++) graph[j] = new ArrayList<>();

      for(int j=1; j<=E; j++){
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        graph[n1].add(n2);
        graph[n2].add(n1);
      }

      for(int j=1; j<=V; j++){
        if (isEven) dfs(j);
        else break;
      }

      if(isEven) System.out.println("YES");
      else System.out.println("NO");
    }
  }
  static void dfs(int node){
    visited[node] = true;

    for(int i : graph[node]){
      if(visited[i]== false){
        check[i] = (check[node]+1)%2;
        dfs(i);
      }else if(check[i]==check[node]){
        isEven = false;
      }
    }
  }
}
