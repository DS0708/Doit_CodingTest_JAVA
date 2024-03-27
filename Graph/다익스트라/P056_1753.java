package Graph.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P056_1753 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int startNode = Integer.parseInt(br.readLine());
    int[] distance = new int[V+1];
    boolean[] visited = new boolean[V+1];
    ArrayList<ArrayList<Edge_1753>> edgeList = new ArrayList<>();
    PriorityQueue<Edge_1753> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.value,o2.value));

    for(int i=0; i<=V; i++){
      edgeList.add(new ArrayList<>());
      distance[i] = Integer.MAX_VALUE;
    }

    for(int i=1; i<=E; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      edgeList.get(s).add(new Edge_1753(e,v));
    }

    //Dijkstra
    pq.offer(new Edge_1753(startNode,0));
    distance[startNode] = 0;
    while(!pq.isEmpty()){
      Edge_1753 now = pq.poll();
      int nowNode = now.node;
      int nowDistacne = now.value;  //시작노드에서 현재노드까지의 값이 큐에 추가되므로 nowDistance라고 표현

      if (visited[nowNode]) continue;
      visited[nowNode] = true;

      for(Edge_1753 next : edgeList.get(nowNode)){
        int nextNode = next.node;
        int nextValue = next.value;
        if(distance[nextNode] > nowDistacne + nextValue){
          distance[nextNode] = nowDistacne + nextValue;
          pq.add(new Edge_1753(nextNode, distance[nextNode]));
          //시작노드에서 다음노드까지의 에지를 하나라고 생각하고 추가해주기, ex) 1 -> 3 -> 4 를 그냥 1번에서 4번으로 가는 엣지 하나라고 생각하기
        }
      }
    }

    //print Result
    for(int i=1; i<=V; i++){
      if (visited[i]) System.out.println(distance[i]);
      else System.out.println("INF");
    }
  }
}

class Edge_1753{
  int node;
  int value;
  Edge_1753(int node,int value){
    this.node = node;
    this.value = value;
  }
}
