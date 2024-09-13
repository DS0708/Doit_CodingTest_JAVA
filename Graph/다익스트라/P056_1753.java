package Graph.다익스트라;

import java.io.*;
import java.util.*;

public class P056_1753 {
  static ArrayList<Edge1753>[] graph;
  static int[] DP;
  static boolean[] visited;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    //input
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(br.readLine());

    int max = (int)1e6; //가중치 최대 * 에지의 최대 갯수  보다 큰 수

    graph = new ArrayList[V+1];
    for(int i=1; i<=V ; i++) graph[i] = new ArrayList<>();

    visited = new boolean[V+1];

    DP = new int[V+1];
    Arrays.fill(DP,max);

    for(int i=1; i<=E; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph[s].add(new Edge1753(e,w));
    }

    //Dijkstra Logic
    dijkstra(K);

    //output
    for(int i=1; i<=V; i++) {
      if(DP[i]==max) bw.write("INF\n");
      else bw.write(DP[i]+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  static void dijkstra(int start) {
    PriorityQueue<Edge1753> pq = new PriorityQueue<>((o1,o2)->o1.weight-o2.weight);
    pq.add(new Edge1753(start,0));
    DP[start] = 0; //출발점 0로직을 여기에 포함해야한다.

    while(!pq.isEmpty()){
      Edge1753 cur = pq.poll();
      //visited가 true라면 현재 값보다 더 작은 weight로 나온적이 있는 노드이다.
      //그때그때 최선의 선택을 하기 때문에, 나중에 개척된 길을 통해 이미 지나간 노드에 대하여 최소 weight는 나오는 경우가 없다.
      //만약 있다면, 그것은 음수 가중치가 존재하는 것임.
      if(visited[cur.node]) continue; //그래서 이미 방문한 곳은 안해도 된다.
      visited[cur.node] = true;
      //현재 노드로 선택된 곳은, 최소 길이가 보장되므로
      // 여기서 갈 수 있는 곳 중 방문하지 않았고
      // DP의 길이가 갱신되는 곳이라면 pq에 추가
      for(Edge1753 next : graph[cur.node]){
        if(!visited[next.node] && cur.weight+next.weight < DP[next.node]){
          DP[next.node] = cur.weight+next.weight;
          pq.add(new Edge1753(next.node,DP[next.node]));
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
