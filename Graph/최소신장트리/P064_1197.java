package Graph.최소신장트리;

import java.io.*;
import java.util.*;

public class P064_1197 {
  static class Edge1197{
    int s;
    int e;
    int v;
    Edge1197(int s, int e, int v){
      this.s =s;
      this.e = e;
      this.v = v;
    }
  }
  static int[] parent;
  static long result;
  static PriorityQueue<Edge1197> Edges;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    parent = new int[V+1];
    for(int i=1; i<=V; i++) parent[i] = i;
    Edges = new PriorityQueue<>((o1,o2)->{
      return o1.v - o2.v;
    });
    result = 0;

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      Edges.add(new Edge1197(s,e,v));
    }
    //Kruskal + Union-Find
    int edgeCount = 0;
    while(edgeCount<V-1){
      Edge1197 current = Edges.poll();

      if(find(current.s) != find(current.e)){
        result += current.v;
        edgeCount++;
        union(current.s, current.e);
      }
    }

    System.out.println(result);
  }

  static void union(int n1, int n2){
    int a = find(n1);
    int b = find(n2);
    if(a!=b){
      parent[a] = b;
    }
  }
  static int find(int num){
    if(parent[num]==num) return num;
    else return parent[num] = find(parent[num]);
  }

}
