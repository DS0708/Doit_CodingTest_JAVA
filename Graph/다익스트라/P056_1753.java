package Graph.다익스트라;

import Search.bfs.Edge;

import java.io.*;
import java.util.*;

public class P056_1753 {
  static ArrayList<Edge1753>[] graph;
  static int[] DP;
  static boolean[] visited;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    //input
    int V = Integer.parseInt(input[0]);
    int E = Integer.parseInt(input[0]);
    int K = Integer.parseInt(br.readLine());

    int max = (int)1e6; //가중치 최대 * 에지의 최대 갯수  보다 큰 수

    graph = new ArrayList[V+1];
    Arrays.fill(graph,new ArrayList<>());

    visited = new boolean[V+1];

    DP = new int[V+1];
    Arrays.fill(DP,max);
    DP[K] = 0;

    for(int i=1; i<=E; i++){
      input = br.readLine().split(" ");
      int s = Integer.parseInt(input[0]);
      int e = Integer.parseInt(input[1]);
      int w = Integer.parseInt(input[2]);
      graph[s].add(new Edge1753(e,w));
    }

    //Dijkstra Logic
    dijkstra(K);

    //output
    for(int i=1; i<=V; i++) {
      if(DP[i]==max) System.out.println("INF");
      else System.out.println(DP[i]);
    }
  }

  static void dijkstra(int start){
    PriorityQueue<Edge1753> pq = new PriorityQueue<>((o1,o2)->o1.weight-o2.weight);
    pq.add(new Edge1753(start,0));
    visited[start] = true;

    while(!pq.isEmpty()){
      Edge1753 cur = pq.poll();
      int curNode = cur.node;
      int curWeight = cur.weight;
      for(Edge1753 edge : graph[curNode]){
        if(!visited[edge.node] && curWeight+edge.weight < DP[edge.node]){
          visited[edge.node] = true;
          DP[edge.node] = curWeight+edge.weight;
          pq.add(new Edge1753(edge.node,DP[edge.node]));
        }
      }
    }

  }
}

class Edge1753{
  int node;
  int weight;
  Edge1753(int node, int weight){
    this.node = node;
    this.weight = weight;
  }
}

// 방향 그래프, 시작점에서 -> 모든 정점의 최단 경로 구하기, 가중치는 10이하의 자연수
// 시작->모든정점의 최단경로 + 양의 가중치 = 다익스트라 , Time Complexity = O( E*LogV )

//입력
// 1<= V <= 20,000, 1<= E <= 30,000
// 시작 정점의 번호 K
// 셋째 줄부터 E개의 줄에, 각 간선을 나타내는  u,v,w , u->v로 가중치 w
// w는 10이하의 자연수
// 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있다.

//출력
// 시작점으로부터 모든 경로까지의 최단 경로값 출력
// 자기 자신은 0, 경로가 존재하지 않으면 INF 출력
