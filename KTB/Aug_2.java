package KTB;

import java.io.*;
import java.util.*;
class Aug_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = (int)1e9 + 7;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] map = new long[N+1][M+1];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = -1;
        }

        //DP(Bottom Up) -> 시간복잡도 M*N*6
        map[1][1] = 1;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                //휴식칸에는 갈 수 없으므로 통과
                if(map[i][j]==-1) continue;
                //DP Logic
                for(int k=1; k<=6; k++){
                    if(i-k>=1 && map[i-k][j]!=-1){
                        map[i][j] = (map[i][j]+map[i-k][j])%mod;
                    }
                    if(j-k>=1 && map[i][j-k]!=-1){
                        map[i][j] = (map[i][j]+map[i][j-k])%mod;
                    }
                }
            }
        }
        //output
        System.out.println(map[N][M]);
    }
}

// 요구사항
// N * M -> (i,j)
// start : (1,1)
// end : (M,N)
// K개의 휴식 칸
// 1~6 주사위 : x -> (r+x, c) or (r, c+x)
// N,M 에 도착할 때까지 주사위를 던져 이동
// 출발지에서 시작해 휴식 칸을 거치지 않고 주사위를 굴려야 하는 경우의 수

// (i,j) = (i-1,j) + (i-2,j) + ... + (i-6,j) + (i,j-1) + .. + (i,j-6)
// 이 중, 1<=i<=N, 1<=j<=M 이고, rest에 속하면 안된다.





