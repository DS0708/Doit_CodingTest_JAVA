package Search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P028_1167 {
    static List<Edge> tree[];
    static boolean visited[];
    static int V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];
        visited = new boolean[V+1];

        for (int i=1; i<=V ; i++){
            tree[i] = new ArrayList<>();
        }

        //tree에 입력
        for (int i=1; i<=V; i++){
            st = new StringTokenizer(br.readLine());
            int now_v = Integer.parseInt(st.nextToken());
            int tar_v;
            while ( (tar_v = Integer.parseInt(st.nextToken())) != -1) {
                int weight = Integer.parseInt(st.nextToken());
                tree[now_v].add(new Edge(tar_v,weight));
            }
        }

        Edge end = BFS(1);
        System.out.println(end.weight);
    }

    public static Edge BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        int weight_arr[] = new int[V+1];
        int max_index=-1;
        int max_length=-1;

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int poll = queue.poll();
            for (Edge edge : tree[poll]){
                if (visited[edge.node]==false){
                    queue.add(edge.node);
                    visited[edge.node] = true;
                    weight_arr[edge.node] = weight_arr[poll] + edge.weight;
                }
            }
        }

        //최대값인 Index와 길이 구하기
        for (int i=1; i<=V; i++){
            if (max_length < weight_arr[i]){
                max_index = i;
                max_length = weight_arr[i];
            }
        }

        visited = new boolean[V+1];
        return new Edge(max_index,max_length);
    }
}

class Edge{
    int node;
    int weight;
    public Edge(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
