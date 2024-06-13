package Search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P025_13023 {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static boolean check;
  static int V;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    graph = new ArrayList[V];
    check = false;
    visited = new boolean[V];
    for(int i=0; i<V; i++){
      graph[i] = new ArrayList<>();
    }

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int e1 = Integer.parseInt(st.nextToken());
      int e2 = Integer.parseInt(st.nextToken());
      graph[e1].add(e2);
      graph[e2].add(e1);
    }

    for(int i=0; i<V; i++){
      DFS(i,1);
      if(check) break;
    }

    if(check) System.out.println(1);
    else System.out.println(0);
  }

  public static void DFS(int now, int depth){
    if(depth==V || check){
      check = true;
      return;
    }

    visited[now] = true;

    for(int i : graph[now]){
      if(!visited[i]) DFS(i,depth+1);
    }

    //나오면서 다시 방문하지 않은 척 해야함
    visited[now] = false;
  }
}
