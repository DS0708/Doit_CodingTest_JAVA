package Graph.다익스트라;

import java.util.*;
import java.io.*;

public class P_1504 {
    static ArrayList<Edge1504>[] graph;
    static boolean[] visited;
    static int max = (int)1e8*3;
    static int[] DP;
    static int V;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();
        DP = new int[V+1];

        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge1504(e,w));
            graph[e].add(new Edge1504(s,w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,V);
        int res2 = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,V);

        //output
        if(res1>=max && res2>=max) System.out.println(-1);
        else System.out.println(Math.min(res1,res2));
    }
    static int dijkstra(int s, int e){
        Arrays.fill(DP,max);
        PriorityQueue<Edge1504> pq = new PriorityQueue<>((o1,o2)->o1.weight-o2.weight);
        pq.add(new Edge1504(s,0));
        visited = new boolean[V+1];
        DP[s]=0;

        while(!pq.isEmpty()){
            Edge1504 cur = pq.poll();
            if(visited[cur.node]) continue;
            visited[cur.node] = true;

            if(cur.node==e) break;

            for(Edge1504 next : graph[cur.node]){
                if(!visited[next.node] && cur.weight+next.weight<DP[next.node]){
                    DP[next.node] = cur.weight+next.weight;
                    pq.add(new Edge1504(next.node,DP[next.node]));
                }
            }
        }

        return DP[e];
    }
}
class Edge1504{
    int node;
    int weight;
    Edge1504(int n, int w){
        this.node = n;
        this.weight = w;
    }

}


//방향성 없는 그래프
//1번 정점에서 N번 정점으로 최단 거리
//두 가지 조건을 만족하면서 이동하는 특정한 최단 경로
// 1. 임의로 주어진 두 정점은 반드시 통과해야 함
// 2. 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동 가능
// 3. 하지만 반드시 최단 경로로 이동해야 한다.
// 문제 : 1 -> N 으로 갈때, 두 정점을 반드시 거치는 최단 경로

//입력
//N(V) E , 2<=V<=800, 0<=E<=200000
// E개 만큼 , a -> b , c (양방향), 1<=c<=1,000
// 다음 줄에는 반드시 거쳐야하는 두개의 서로 다른 정점 v1 v2, v1은 N이 아니고 v2는 1이 아님
// 임의의 두 정점 u,v 사이에는 간선이 최대 1개 존재한다.

//출력
// 두 개의 정점을 지나는 최단 경로 길이 출력
// 그러한 경로가 없을 때에는 -1 출력

// idea : 다익스트라 6번
// 1->v1, 1->v2, v1->v2(양방향이니까 한번), v1->N, v2->N
// 1) 1->v1 + v1->v2 + v2->N
// 2) 1->v2 + v2->v1(v1->v2) + v1->N
// 1)와 2) 중 더 작은 값을 고르면 된다.
// 만약 두 값이 둘,다 max보다 크다면 -1을 출력

// 시간복잡도
// 다익스트라 6번 = ELogV * 6 = 200,000 * 10 * 6 = 약 10,000,000 -> 약 0.01초


