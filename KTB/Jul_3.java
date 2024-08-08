package KTB;

import java.io.*;
import java.util.*;
public class Jul_3 {
    static int N,M;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long earnMoney = 0;
        long tax = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cr=0;
        int cc=0;
        int sr,sc,er,ec;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            sc = Integer.parseInt(st.nextToken());
            sr = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());
            er = Integer.parseInt(st.nextToken());
            if(i==0) {
                cr = sr;
                cc = sc;
            }
            int distance;
            //c -> s, tax만 증가
            distance = BFS(cr,cc,sr,sc);
            tax += Z * distance;
            //s -> e, tax랑 earnMoney 증가
            distance = BFS(sr,sc,er,ec);
            tax += Z * distance;
            if(distance <= 5) earnMoney += X;
            else earnMoney += X + (distance-5)*Y;
            //현재 지점 변경
            cr = er;
            cc = ec;
        }
        //결과 출력
        System.out.println(earnMoney-tax);
    }
    static int BFS(int sr,int sc,int er,int ec){
        int[][] visited = new int[N+1][N+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {sr,sc});
        visited[sr][sc] = 1;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cr = current[0];
            int cc = current[1];

            if(cr==er&&cc==ec) break;

            for(int i=0; i<4; i++){
                int tr = cr + dr[i];
                int tc = cc + dc[i];
                if(1<=tr&&tr<=N && 1<=tc&&tc<=N){
                    if(visited[tr][tc]==0 && map[tr][tc]==0){
                        visited[tr][tc] = visited[cr][cc] + 1;
                        queue.add(new int[] {tr,tc});
                    }
                }
            }

        }

        return visited[er][ec]-1;
    }
}


// N*N 의 격자 형태 맵
// a번째열, b번째 행 -> (a,b) -> r=b, c=a
// 0은 이동 가능
// 1은 이동 불가능

// 요금 체계
// 승차 지점 하차 지점 사이의 이동 거리가 5이하이면 =>  X의 기본 요금
// 5이상이면 => X + 초과한 거리 * Y
// 택시가 1만큼 이동할 때마다 Z의 통행료 => 이동거리 * Z
// 통행료는 구름이가 번 돈에서 빠져나감

// M명의 손님을 태움
// 항상 최단 경로로 이동
// 하차 지점에 내려주고 승차 지점으로 이동
// 처음 구름이의 택시는 첫 손님의 승차 지점

//순수익 구하기 => 순수익 = 그날 번 돈 - 통행료


//입력
// N M
// X Y Z
// 다음 N개의 줄에는 구름시의 지도를 나타내는 N개의 문자가 공백으로 주어짐
// 다음 M개의 줄에는 a b c d => (a,b)는 승차 지점 (c,d)는 하차 지점

//조건
//









