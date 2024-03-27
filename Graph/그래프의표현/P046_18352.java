package Graph.그래프의표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P046_18352 {
  static boolean visited[];
  static Queue<Integer> queue;
  static ArrayList<Integer> graph[];
  static int D[];
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    boolean check = false;

    D = new int[N+1];
    queue = new LinkedList<>();
    visited = new boolean[N+1];
    graph = new ArrayList[N+1];
    for (int i=1 ;i<=N ; i++){
      graph[i] = new ArrayList<>();
    }

    for (int i=1; i<=M; i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end  = Integer.parseInt(st.nextToken());
      graph[start].add(end);
    }

    BFS(X);

    for (int i=1; i<=N; i++){
      if(D[i]==K){
        check = true;
        System.out.println(i);
      }
    }

    if(!check) System.out.println(-1);
  }

  public static void BFS(int start){
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()){
      int current = queue.poll();
      for (int i : graph[current]){
        if (visited[i] == false){
          visited[i] = true;
          D[i] = D[current] + 1;
          queue.add(i);
        }
      }
    }

  }
}
