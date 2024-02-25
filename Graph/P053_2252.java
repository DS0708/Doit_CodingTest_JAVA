package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class P053_2252 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    ArrayList<Integer>[] graph = new ArrayList[N+1];
    int indegree[] = new int[N+1];
    Queue<Integer> queue = new ArrayDeque<>();

    //graph init
    for(int i=1; i<=N; i++){
      graph[i] = new ArrayList<>();
    }
    //insert into graph
    for(int i=0; i<M; i++){
      int node1 = scanner.nextInt();
      int node2 = scanner.nextInt();
      graph[node1].add(node2);
      indegree[node2]++;
    }
    //
    //Topology Sort
    //
    for (int i=1; i<=N; i++){
      if (indegree[i]==0) queue.offer(i);
    }

    while(!queue.isEmpty()){
      int now = queue.poll();
      System.out.print(now+" ");
      for (int i : graph[now]){
        indegree[i] --;
        if (indegree[i]==0) queue.offer(i);
      }
    }

  }


}
