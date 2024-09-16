package Class3;

import java.util.*;
import java.io.*;

public class P_1697 {
    static int INF = (int)1e5+1;
    static int[] D;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        D = new int[INF];
        visited = new boolean[INF];

        if(n>=k) D[k] = n-k;
        else bfs(n,k);

        System.out.println(D[k]);
    }
    static void bfs(int s,int e){
        Queue<Integer> q = new ArrayDeque<>();
        visited[s]=  true;
        q.add(s);

        while(!q.isEmpty()){
            int cur = q.poll();
            int plus = cur+1;
            int minus = cur-1;
            int shift = cur*2;
            if(plus<INF && !visited[plus]){
                q.add(plus);
                D[plus] = D[cur]+1;
                visited[plus] = true;
            }
            if(minus>=0 && !visited[minus]){
                q.add(minus);
                D[minus] = D[cur]+1;
                visited[minus] = true;
            }
            if(shift<INF && !visited[shift]){
                q.add(shift);
                D[shift] = D[cur]+1;
                visited[shift] = true;
            }
            if(plus==e || minus==e || shift==e) break;
        }
    }


}

//수빈 점 N, 동생 점 K -> 0<=N,K<=100,000
//수빈이는 걷거나 순간이동 가능
//수빈이가 걷는다면 1초 후에 X+1, X-1
//순간이동을 하는 경우는 1초 후에 2*X
//수빈이와 동생의 위치가 주어졌을 때, 동생을 찾을 수 있는 가장 빠른 시간은 몇 초 후인가

//입력
// N과 K가 주어지고 정수임
