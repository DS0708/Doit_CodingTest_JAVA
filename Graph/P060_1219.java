package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge_1219{
  int start;
  int end;
  int val;
  Edge_1219(int start, int end, int val){
    this.start = start;
    this.end = end;
    this.val = val;
  }
}

public class P060_1219 {
  static ArrayList<Edge_1219> graph;
  static long[] dist;
  static int[] city_money;
  static int n;
  static int m;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    dist = new long[n];
    city_money = new int[n];
    Set<Integer> cycleSet = new HashSet<>();

    //input
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph.add(new Edge_1219(s,e,v));
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      city_money[i] = Integer.parseInt(st.nextToken());
      dist[i] = Long.MIN_VALUE;
    }

    //Bellman-Ford
    boolean check = true;
    dist[start] = city_money[start];
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        Edge_1219 now = graph.get(j);
        if(dist[now.start] != Long.MIN_VALUE && dist[now.end] < dist[now.start] - now.val + city_money[now.end]){
          dist[now.end] = dist[now.start] - now.val + city_money[now.end];
        }
      }
    }

    for(int j=0; j<m; j++){
      Edge_1219 now = graph.get(j);
      if(dist[now.start] != Long.MIN_VALUE && dist[now.end] < dist[now.start] - now.val + city_money[now.end]){
        check = false;
        cycleSet.add(now.end);
      }
    }

    //양수 싸이클이 존재한다면, 양수 싸이클에서 도착노드까지 도달할 수 있는지 확인
    //도달할 수 없다면 check를 true로 변경
    if (!check){
      for(int cycleNode : cycleSet){
        //cycleNode에서 end로 갈 수 있으면 True를 return하는 BFS실행
        check = !BFS(cycleNode,end);
        //BFS가 true이면 check가 false이고 더 진행할 필요가 없다.
        // 여러 개의 싸이클 중 end로 하나라도 갈 수 있으면 더 이상 진행할 필요가 없음.
        if(!check) break;
      }
    }

    //output
    if(dist[end] == Long.MIN_VALUE){
      System.out.println("gg");
    }else{
      if(check){
        System.out.println(dist[end]);
      }else{
        System.out.println("Gee");
      }
    }
  }
  static boolean BFS(int start, int end){
    //cycleSet에 end노드가 포함되어 있다면 바로 true 리턴
    if (start == end) return true;

    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[n];

    queue.offer(start);
    visited[start] = true;

    while(!queue.isEmpty()){
      int now = queue.poll();
      for(int i=0; i<m ;i++){
        Edge_1219 edge = graph.get(i);
        if(now != edge.start) continue;
        if(!visited[edge.end]){
          queue.offer(edge.end);
          visited[edge.end] = true;
        }
      }
    }

    return visited[end];
  }

}
