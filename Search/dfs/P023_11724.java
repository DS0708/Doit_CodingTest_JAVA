package Search.dfs;

import java.io.*;
import java.util.*;

public class P023_11724 {
  static ArrayList<Integer>[] graphList;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    graphList = new ArrayList[V+1];
    visited = new boolean[V+1];

    int result = 0;

    for(int i=1; i<=V; i++){
      graphList[i] = new ArrayList<>();
    }

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int e1 = Integer.parseInt(st.nextToken());
      int e2 = Integer.parseInt(st.nextToken());
      graphList[e1].add(e2);
      graphList[e2].add(e1);
    }

    while(true){
      int index = -1;
      for(int i=1; i<=V; i++){
        if(!visited[i]) index = i;
      }

      if(index==-1){
        break;
      }else{
        DFS(index);
        result++;
      }
    }

    System.out.println(result);
  }

  static void DFS(int node){
    visited[node] = true;

    for(int newNode : graphList[node]){
      if(!visited[newNode])
        DFS(newNode);
    }
  }

}
