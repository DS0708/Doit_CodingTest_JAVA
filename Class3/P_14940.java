package Class3;

import java.io.*;
import java.util.*;

public class P_14940 {
    static int n,m;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] start = new int[2];

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur==2) {
                    start[0]=i;
                    start[1]=j;
                }
                map[i][j]=cur;
            }
        }

        bfs(start[0],start[1]);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(visited[i][j]==false && map[i][j]==1) System.out.print(-1+" ");
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void bfs(int start, int end) {
        visited[start][end]=true;
        map[start][end] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {start,end});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(0<=nr&&nr<n && 0<=nc&&nc<m && !visited[nr][nc] && map[nr][nc]==1){
                    map[nr][nc] = map[cur[0]][cur[1]] + 1;
                    visited[nr][nc] = true;
                    q.add(new int[] {nr,nc});
                }
            }
        }

    }
}


//map에서 모든 지점에 대해서 목표지점까지의 거리 구하기
//가로 세로만 움직이는거 가능
// 0 갈수 없, 1 갈수 있, 2는 목표지점 (2는 1개)

//입력
// n m , 2<= n,m <= 1000

//idea : 완전 탐색 BFS
//시작점을 0으로 바꾸고 출발, 상하좌우
//1이라면 가고, 그 전 거리에서 + 1
//0이라면 stop
//완전탐색 수행후, 방문하지 않은 곳 중에서 1인 곳을 -1