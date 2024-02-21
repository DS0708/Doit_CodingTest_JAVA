package Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class P047_1325 {
  static int N,M;
  static ArrayList<Integer> graph[];
  static boolean visited[];
  static int trust_count[];
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    graph = new ArrayList[N+1];
    trust_count = new int[N+1];
    int max_trust_count = -1;

    for (int i=1; i<N+1; i++){
      graph[i] = new ArrayList<>();
    }

    for(int i=1; i<M+1; i++){
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());
      graph[n1].add(n2);
    }

    for (int i=1; i<N+1; i++){
      visited = new boolean[N+1];
      BFS(i);
      //DFS(i);
    }

    for (int i=1; i<N+1; i++){
      max_trust_count = Math.max(trust_count[i],max_trust_count);
    }
    for (int i=1; i<N+1; i++){
      if (max_trust_count==trust_count[i]) System.out.print(i+" ");
    }
  }

  static void BFS(int start){
    Queue<Integer> queue = new ArrayDeque<>();

    queue.add(start);
    visited[start] = true;

    while(!queue.isEmpty()){
      int current = queue.poll();
      for (int i : graph[current]){
        if(visited[i]==false){
          queue.add(i);
          visited[i] = true;
          trust_count[i]++;
        }
      }
    }
  }

  static void DFS(int start){
    visited[start] = true;
    for (int i : graph[start]){
      if(!visited[i]) {
        trust_count[i]++;
        DFS(i);
      }
    }
  }


}
