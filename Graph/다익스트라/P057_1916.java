package Graph.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P057_1916 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    int[] distance = new int[N+1];
    boolean[] visited = new boolean[N+1];
    ArrayList<ArrayList<Edge_1916>> graph = new ArrayList<>();
    for(int i=0; i<=N; i++){
      distance[i] = Integer.MAX_VALUE;
      graph.add(new ArrayList<>());
    }
    PriorityQueue<Edge_1916> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.value,o2.value)));

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.get(s).add(new Edge_1916(e,v));
    }
    st = new StringTokenizer(br.readLine());
    int startNode = Integer.parseInt(st.nextToken());
    int endNode = Integer.parseInt(st.nextToken());

    //다익스트라
    pq.offer(new Edge_1916(startNode,0));
    distance[startNode] = 0;

    while(!pq.isEmpty()){
      Edge_1916 now = pq.poll();
      int now_target = now.targetNode;
//      int now_target_value = now.value;

      if (visited[now_target]) continue;

      visited[now_target] = true;
      for (Edge_1916 check : graph.get(now_target)){
        int checkNode = check.targetNode;
        int checkValue = check.value;
        if(distance[checkNode] > distance[now_target] + checkValue){
          int newValue = distance[now_target] + checkValue;
          distance[checkNode] = newValue;
          pq.offer(new Edge_1916(checkNode,newValue));
        }
      }
    }

    //결과 출력
    System.out.println(distance[endNode]);
  }
}

class Edge_1916{
  int targetNode;
  int value;
  Edge_1916(int targetNode, int value){
    this.targetNode = targetNode;
    this.value = value;
  }
}
