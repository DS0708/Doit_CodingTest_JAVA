package Graph.다익스트라;

import java.io.*;
import java.util.*;

public class P056_1753 {
  static int[] D;
  static ArrayList<Edge1753>[] graph;
  static boolean[] visited;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(br.readLine());

    D = new int[V+1];
    graph = new ArrayList[V+1];
    visited = new boolean[V+1];
    for(int i=1; i<=V; i++){
      graph[i] = new ArrayList<>();
      D[i] = Integer.MAX_VALUE;
    }

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[s].add(new Edge1753(e,v));
    }

    dijkstra(start);

    for(int i=1; i<=V; i++){
      if(visited[i]) System.out.println(D[i]);
      else System.out.println("INF");
    }

  }

  static void dijkstra(int start){
    //다익스트라 기본 로직 :
    //큐에 있는 노드 중, 갈 수 있는 비용이 제일 적은 노드를 선택 (그리디)
    //그 노드에 간 후, 방문했다고 표시한다.
    //그 노드에서 방문할 수 있는 노드들을 살펴본다.(살펴보는게 중요함)
    //살펴본 다음에 최소 비용으로 갈 수 있는 노드들만 큐에 담고 최소거리 배열(D)를 초기화해준다.
    //이때 중요한 것은 (지금까지 왔던 비용) + (현재 노드에서 새로운 노드로 가는 비용) 을 더한 값을 에지의 비용으로 담는다.
    //쉽게 생각하면, 큐에 담아지는 노드와 비용은, 시작점부터 그 노드까지의 비용이 하나의 에지라고 생각하고 담는 것
    //예를 들자면, "시작점->중간노드->중간노드->목표노드"의 에지를 담는 것이 아닌 "시작점->목표노드"라고 생각하고 담는 것 !!
    PriorityQueue<Edge1753> pq = new PriorityQueue<>();
    D[start] = 0;
    //시작점을 첫 노드로 0만큼 간다고 생각해야함
    pq.offer(new Edge1753(start,0));

    while(!pq.isEmpty()){
      Edge1753 current = pq.poll();
      visited[current.node] = true;
      for(Edge1753 next : graph[current.node]) {
        int targetVal = D[current.node]+next.val;
        if(!visited[next.node] && targetVal < D[next.node]) {
          D[next.node] = targetVal;
          pq.offer(new Edge1753(next.node, targetVal));
        }
      }
    }
  }

  static class Edge1753 implements Comparable<Edge1753>{
    int node;
    int val;
    Edge1753(int node, int val){
      this.node = node;
      this.val = val;
    }
    @Override
    public int compareTo(Edge1753 t){
      return this.val - t.val;
    }
  }
}
