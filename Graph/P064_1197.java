package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P064_1197 {
  static int[] parent;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    parent = new int[n+1];
    for(int i=1; i<=n; i++) parent[i] = i;
    PriorityQueue<Edge_1197> pq = new PriorityQueue<>();
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      int V = Integer.parseInt(st.nextToken());
      pq.offer(new Edge_1197(S,E,V));
    }

    int useEdge = 0;
    int result = 0;
    while(useEdge < n-1){
      Edge_1197 nowEdge = pq.poll();
      if(find(nowEdge.s) != find(nowEdge.e)){
        union(nowEdge.s, nowEdge.e);
        result += nowEdge.v;
        useEdge ++;
      }
    }

    System.out.println(result);
  }
  static void union(int x, int y){
    x = find(x);
    y = find(y);
    if(x!=y){
      parent[y] = x;
    }
  }
  static int find(int x){
    if(x == parent[x]) return x;
    else return parent[x] = find(parent[x]);
  }
}

class Edge_1197 implements Comparable<Edge_1197>{
  int s;
  int e;
  int v;
  Edge_1197(int s,int e,int v){
    this.s = s;
    this.e = e;
    this.v = v;
  }
  @Override
  public int compareTo(Edge_1197 o) {
    return this.v - o.v;
  }
}
