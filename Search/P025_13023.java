package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P025_13023 {
    static ArrayList<Integer>[] graph;
    static boolean arrive;
    static Boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        arrive = false;
        visited = new Boolean[V];

        graph = new ArrayList[V];
        for (int i=0; i<V; i++){
            graph[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i=0; i<V; i++){
            DFS (i,1);

            if (arrive) break;
        }

       if(arrive) System.out.println(1);
       else System.out.println(0);
    }

    public static void DFS(int now, int depth){
        if (depth ==5){
            arrive = true;
            return;
        }
        visited[now] = true;

        for (int i : graph[now]){
            if (visited[i] == false){
                DFS(i,depth+1);
            }
        }

        visited[now] = false;
    }
}
