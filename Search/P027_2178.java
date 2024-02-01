package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P027_2178 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int map[][] ;
    static boolean visited[][];
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        BFS(0,0);

        System.out.println(map[N-1][M-1]);
    }

    public static void BFS(int i, int j){
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {i,j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for (int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if ( 0<=x&&x<N && 0<=y&&y<M){
                    if (map[x][y]>0 && visited[x][y]==false){
                        queue.add(new int[] {x,y});
                        visited[x][y] = true;
                        map[x][y] = map[now[0]][now[1]] + 1;
                    }
                }
            }
        }
    }
}
