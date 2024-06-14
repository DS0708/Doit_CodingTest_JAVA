package Search.bfs;

import java.io.*;
import java.util.*;

public class P026_1260 {
  static BufferedWriter bw;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());

    graph = new ArrayList[V+1];
    for(int i=1; i<=V; i++){
      graph[i] = new ArrayList<>();
    }

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int e1 = Integer.parseInt(st.nextToken());
      int e2 = Integer.parseInt(st.nextToken());
      graph[e1].add(e2);
      graph[e2].add(e1);
    }

    for(int i=1; i<=V; i++){
      Collections.sort(graph[i]);
    }

    visited = new boolean[V+1];
    DFS(start);
    bw.write("\n");
    visited = new boolean[V+1];
    BFS(start);


    bw.flush();
    bw.close();
    br.close();
  }

  static void DFS(int node) throws IOException{
    bw.write(node+" ");
    visited[node] = true;
    for(int i : graph[node]){
      if(!visited[i]) DFS(i);
    }
  }
  static void BFS(int node) throws IOException{
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(node);
    visited[node] = true;
    bw.write(node+" ");

    while(!queue.isEmpty()){
      int searchNode = queue.poll();
      for(int i : graph[searchNode]){
        if(!visited[i]) {
          queue.add(i);
          visited[i] = true;
          bw.write(i+" ");
        }
      }
    }

  }
}
