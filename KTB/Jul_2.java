package KTB;

import java.io.*;
import java.util.*;

public class Jul_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][M+1];

        int[][] panda = new int[K+1][2];

        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            panda[i][0] = r;
            panda[i][1] = c;
            map[r][c] = -1;
        }

        long result = Long.MAX_VALUE;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(map[i][j]==-1) continue;
                long dontLike = 0;
                for(int z=1; z<=K; z++){
                    dontLike += (i-panda[z][0])*(i-panda[z][0]) + (j-panda[z][1])*(j-panda[z][1]);
                }
                result = Math.min(result,dontLike);
            }
        }

        System.out.println(result);
    }
}

//문제
// 숲 : N*M, K마리의 판다 (1 , 2 ... K)
//판다는 다른 칸으로 이동하지 않음, 하나의 칸에는 하나의 판다만 산다.
//구름이는 판다가 살고 있지 않은 칸에 살아야함
//불만족도가 가장 낮은 칸을 선택 -> 구하기
//i번 판다가 Ri번째 행, Ci번째 열에 살 때, i번 판다와의 거리는 (r-Ri)^2 + c(c-Ci)^2
//불만족도 = 모든 판다와의 거리의 합 -> 판다와 거리가 가까울 수록 불만족도가 낮다

//입력
// N M K
// K개만큼 Ri Ci -> 판다가 사는 좌표

//조건
// 2<= N,M <= 100
// 1<= K < 10000
// 1 <= Ri, Ci <= N,M
