package Graph.다익스트라;

import java.io.*;
import java.util.*;

public class P058_1854 {
  static class Edge1854{
    int node;
    int val;
    Edge1854(int node, int val){
      this.node = node;
      this.val = val;
    }
  }
  static ArrayList<Edge1854>[] graph;
  static PriorityQueue<Integer>[] Dpq;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    int Dpqsize = Integer.parseInt(st.nextToken());

    graph = new ArrayList[V+1];
    Dpq = new PriorityQueue[V+1];
    for(int i=1; i<=V; i++){
      graph[i] = new ArrayList<>();
      Dpq[i] = new PriorityQueue<>(Dpqsize,(o1, o2)->{
        return o2 - o1;
      });
    }

    for(int i=0; i<E; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      graph[s].add(new Edge1854(e,v));
    }

    dijkstra(1,Dpqsize);

    for(int i=1; i<=V; i++){
      if(Dpq[i].size() == Dpqsize) bw.write(Dpq[i].poll()+"\n");
      else bw.write(-1+"\n");
    }

    bw.flush();
    bw.close();
    br.close();
  }

  static void dijkstra(int start, int Dpqsize){
    PriorityQueue<Edge1854> pq = new PriorityQueue<>((o1,o2)->{
      return o1.val - o2.val;
    });
    pq.offer(new Edge1854(start,0));
    Dpq[start].offer(0);

    while(!pq.isEmpty()){
      Edge1854 current = pq.poll();
      for(Edge1854 next : graph[current.node]){
        int nextVal = current.val + next.val;
        if(Dpq[next.node].size() < Dpqsize){
          Dpq[next.node].offer(nextVal);
          pq.offer(new Edge1854(next.node, nextVal));
        }else if(Dpq[next.node].peek() > nextVal){
          Dpq[next.node].poll();
          Dpq[next.node].offer(nextVal);
          pq.offer(new Edge1854(next.node, nextVal));
        }
      }
    }
  }
}
