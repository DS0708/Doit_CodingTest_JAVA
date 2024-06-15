package Graph.그래프의표현;

import java.io.*;
import java.util.*;

public class P046_18352 {
  static ArrayList<Integer>[] graph;
  static boolean[] visited;
  static int[] D;

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());

    graph = new ArrayList[V+1];
    for(int i=0; i<=V; i++) graph[i] = new ArrayList<>();
    visited = new boolean[V+1];
    D = new int[V+1];

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int e1 = Integer.parseInt(st.nextToken());
      int e2 = Integer.parseInt(st.nextToken());
      graph[e1].add(e2);
    }

    BFS(start);

    boolean check = false;
    for(int i=1; i<=V; i++){
      if(D[i]==K) {
        System.out.println(i);
        check = true;
      }
    }
    if(!check) System.out.println(-1);
  }
  public static void BFS(int s){
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(s);
    visited[s] = true;

    while(!queue.isEmpty()){
      int curNode = queue.poll();
      for(int i : graph[curNode]){
        if(!visited[i]){
          D[i] = D[curNode]+1;
          visited[i] = true;
          queue.offer(i);
        }
      }
    }
  }
}
