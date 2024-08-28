package KTB;

import java.io.*;
import java.util.*;
class Aug_3 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int endV=0;
    static int V;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<V; i++){
            String[] input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        BFS(1);
        int res = BFS(endV);

        System.out.println(res);
    }
    public static int BFS(int start){
        visited = new boolean[V+1];
        Queue<Integer> queue = new ArrayDeque();
        visited[start] = true;
        queue.add(start);

        int depthCount = 1;
        int count = 0;
        int newDepthCount = 0;
        int depth = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            endV = cur;
            count ++;
            for(int next : graph[cur]){
                if(!visited[next]){
                    newDepthCount++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
            if(depthCount==count){
                depthCount = newDepthCount;
                newDepthCount = 0;
                count = 0;
                depth++;
            }
        }
        return depth;
    }
}





