package Search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P026_1260 {
    static List<Integer> graph[];
    static boolean BFS_visited[];
    static boolean DFS_visited[];
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start_V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        BFS_visited = new boolean[V+1];
        DFS_visited = new boolean[V+1];

        for (int i=1; i<=V; i++){
            graph[i] = new ArrayList<>();
            BFS_visited[i] = false;
            DFS_visited[i] = false;
        }

        //graph에 Edge 삽입
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        //graph 오름차순 정렬
        for (int i=1; i<=V; i++){
            graph[i].sort(Comparator.naturalOrder());
        }
        //DFS 실행
        DFS(start_V);

        System.out.println();

        //BFS 실행
        BFS(start_V);
    }

    public static void DFS(int node){
        System.out.print(node+" ");
        DFS_visited[node] = true;

        for (int i : graph[node]){
            if (DFS_visited[i] == false){
                DFS(i);
            }
        }
    }

    public static void BFS(int start_V){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start_V);

        while (queue.isEmpty() == false){
            int poll = queue.poll();
            if (BFS_visited[poll] == false){
                System.out.print(poll+" ");
                BFS_visited[poll] = true;
                for (int j : graph[poll]) queue.add(j);
            }
        }
    }

}
