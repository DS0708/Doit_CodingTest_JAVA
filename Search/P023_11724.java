package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.StringTokenizer;

public class P023_11724 {
    static Collection<Integer>[] graph;
    static Boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        visited = new Boolean[V+1];
        graph = new ArrayList[V+1];
        count = 0;

        //Arraylist 배열 초기화 및 visited 초기화
        for (int i=1; i<=V; i++){
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }

        //그래프에 에지 삽입
        for (int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i=1; i<=V; i++){
            if(visited[i] == false){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    public static void DFS(int v){
        if (visited[v]) return;

        visited[v] = true;
        for (int i : graph[v]){
            if(visited[i] == false)
            DFS(i);
        }
    }
}
